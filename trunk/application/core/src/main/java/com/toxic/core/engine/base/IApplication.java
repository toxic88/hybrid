package com.toxic.core.engine.base;

/**
 * <p>
 * The instance of every application, used by this library.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface IApplication {

  /**
   * Provide possibility create initializing
   */
  public abstract void init();

  /**
   * <p>
   * Will be called sequentially every update.
   * </p>
   * <br/>
   * <p>
   * <b>NOTE : this is very expensive function in term of performance issue.</b>
   * </p>
   * <br/>
   * @param delta time (in ms) since the last update call.
   */
  public abstract void update(int delta);
  
}
