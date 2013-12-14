package com.toxic.core.engine.base;

/**
 * <p>
 * The basic object of activity. It allows update whole scene inner logic and
 * switch between them.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public interface IScene extends IElement {
  
  /**
   * <p>
   * Activate current scene on screen.
   * </p>
   * <p>
   *  <b>NOTE : if currently active some other instance of {@link IScene} it will be deactivated. </b>
   * </p>
   * <br/>
   */
  public abstract void activate();
  
}
