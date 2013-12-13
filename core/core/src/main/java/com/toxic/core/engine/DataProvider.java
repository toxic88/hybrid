package com.toxic.core.engine;

/**
 * <p>
 * Through this object you can create almost all library object.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public class DataProvider {

  // private static DataProvider instance;
  //
  // private DataProvider() {
  // //NOP
  // }

  /**
   * <p>
   * Create default instance of element woth default values.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static IElement createElement() {
    return new BaseElement();
  }

}
