package com.toxic.core.engine.handlers;

import com.toxic.core.engine.events.ActionEvent;

/**
 * <p>
 *  Provide capabilities of handling moving event.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface MoveHandler {

  /**
   * Will be executed when you pressed on element.
   */
  public abstract void onMove(ActionEvent e);

}
