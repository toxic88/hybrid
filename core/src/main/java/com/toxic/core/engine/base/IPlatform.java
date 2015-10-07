package com.toxic.core.engine.base;

import com.toxic.core.engine.util.Context;

/**
 * <p>
 * Contains platform specific implementation object of {@link Context} and
 * application logic engine, representing by object {@link IApplication}.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface IPlatform {

  /**
   * <p>
   * Invoking custom application start to be executed. Represents application
   * logic engine.
   * </p>
   * <br/>
   * @param application
   */
  public abstract IApplication getApp();

  /**
   * @return instance of platform-specific implementation function.
   */
  public abstract Context getContext();
  
  
  /**
   * Start game launching.
   */
  public abstract void start();

}
