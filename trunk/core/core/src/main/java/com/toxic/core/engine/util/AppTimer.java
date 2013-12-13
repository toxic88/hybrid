package com.toxic.core.engine.util;

import com.toxic.core.engine.handlers.CancelHandler;

/**
 * <p>
 * 
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface AppTimer {

  /**
   * <p>
   * Repeatedly execute action after expired milliseconds time.
   * </p>
   * <br/>
   * 
   * @param millis
   * @param action
   * @return
   */
  public abstract CancelHandler every(int millis, Runnable action);

  /**
   * <p>
   * Execute action after expired milliseconds time.
   * </p>
   * <br/>
   * 
   * @param millis
   * @param action
   * @return
   */
  public abstract CancelHandler after(int millis, Runnable action);

  /**
   * <p>
   * Execute action after expired fir milliseconds time's parameter and
   * subsequently repeatedly execute task every repeatMillis milliseconds.
   * </p>
   * <br/>
   * 
   * @param initialMillis
   * @param repeatMillis
   * @param action
   * @return
   */
  public abstract CancelHandler atThenEvery(int initialMillis, int repeatMillis, Runnable action);

  /**
   * <p>
   * Check weather necessary execute any pending task.
   * </p>
   * <br/>
   */
  public abstract void update();

}
