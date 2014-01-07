package com.toxic.core.engine;

import tripleplay.util.Timer.Handle;

import com.toxic.core.engine.handlers.CancelHandler;

/**
 * <p>
 * Implementation of canceling timer's task.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
final class CancelAction implements CancelHandler {

  private final Handle handler;

  /**
   * <p>
   * Appropriated handler for canceling timer's task
   * </p>
   * <br/>
   * 
   * @param handle
   */
  public CancelAction(Handle handle) {
    this.handler = handle;
  }

  @Override
  public void cancel() {
    this.handler.cancel();
    ((TimerUtility) TimerUtility.getInstance()).removeCancelHandler(this);
  }

}
