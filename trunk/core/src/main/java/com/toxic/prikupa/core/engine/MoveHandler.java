/**
 * 
 */
package com.toxic.prikupa.core.engine;

import playn.core.Pointer.Event;

/**
 * @author Strelock
 * 
 */
public interface MoveHandler {

  /**
   * <p>
   * Will be executed when you pressed on element.
   * </p>
   */
  public abstract void onMove(Event e);

}
