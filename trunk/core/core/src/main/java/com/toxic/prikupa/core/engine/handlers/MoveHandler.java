/**
 * 
 */
package com.toxic.prikupa.core.engine.handlers;

import com.toxic.prikupa.core.engine.events.ActionEvent;

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
