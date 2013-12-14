package com.toxic.core.engine;

import com.toxic.core.engine.util.Context;

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
   * Create default instance of element with default values.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static IElement createElement() {
    return new BaseElement();
  }
  
  /**
   * <p>
   * Create {@link IScene} with default parameters. 
   * </p> 
   * <br/>
   * @return
   */
  public static IScene createScene(){
    return new Scene();
  }
  
//  public static Context getContext(){
//    return ;
//  }

}
