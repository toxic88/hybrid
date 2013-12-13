/**
 * 
 */
package com.toxic.core.engine;

import java.util.HashSet;
import java.util.Set;

import playn.core.PlayN;
import playn.core.util.Clock;

/**
 * <p>
 * The basic class of activity. It allows update whole scene inner logic and
 * switch between them.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public final class Scene extends BaseElement {

  private static Set<Scene> stack = new HashSet<Scene>();
  private static Scene current;

  public static Scene getCurrentScene() {
    return current;
  }

  /**
   * <p>
   * Default constructor
   * </p>
   * <br/>
   */
  public Scene() {
    stack.add(this);
    this.setSize(PlayN.graphics().width(), PlayN.graphics().height());
  }

  /**
   * <p>
   * Activate current scene on screen.
   * </p>
   * <br/>
   */
  public void activate() {
    if (current != null) {
      PlayN.graphics().rootLayer().remove(current.layer);
      current.disableElements();
    }
    PlayN.graphics().rootLayer().add(this.layer);
    this.enableElements();
    current = this;
  }

  @Override
  public boolean isRoot() {
    return true;
  }

  /**
   * <p>
   * Update current inner consistency.
   * </p>
   * <br/>
   */
  public final static void update(Clock clock) {
    anim.paint(clock);
  }

}
