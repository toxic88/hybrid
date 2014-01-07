/**
 * 
 */
package com.toxic.core.engine.handlers;

import com.toxic.core.engine.events.ActionEvent;

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
  public abstract void onMove(ActionEvent e);

}
