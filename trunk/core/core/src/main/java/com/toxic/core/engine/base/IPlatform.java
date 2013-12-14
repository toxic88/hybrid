package com.toxic.core.engine.base;

/**
 * @author Strelock
 * 
 */
public interface IPlatform {

  /**
   * <p>
   * Invoking custom application start to be executed, for some of platforms.
   * </p>
   * <br/>
   * 
   * @param application
   */
  public abstract void start(IApplication application);

}
