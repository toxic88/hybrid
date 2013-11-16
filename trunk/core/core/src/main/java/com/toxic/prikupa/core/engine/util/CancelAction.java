package com.toxic.prikupa.core.engine.util;

import tripleplay.util.Timer.Handle;

import com.toxic.prikupa.core.engine.handlers.CancelHandler;

/**
 * <p>
 * Implementation of canceling timer's task.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
class CancelAction implements CancelHandler {

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
