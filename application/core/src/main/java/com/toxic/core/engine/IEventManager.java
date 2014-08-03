/**
 * 
 */
package com.toxic.core.engine;

/**
 * Interface for enable and disable pointer interaction
 * 
 * @author b1gs
 * 
 */
public interface IEventManager {

  /**
   * Enable Pointer interaction
   * 
   * @param flag
   *          (true - enable,false - disable)
   */
  void enableInteraction(boolean flag);

}
