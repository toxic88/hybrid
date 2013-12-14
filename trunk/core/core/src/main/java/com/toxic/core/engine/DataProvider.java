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

   private static DataProvider instance;
   
   private BaseGame application;
  
   private DataProvider() {
   //NOP
   }
   
   /**
   * <p>
   * Weather game has been properly loaded. 
   * </p> 
   * <br/>
   * @return
   */
  private static void checkConditions(){
     if (!(instance!=null && instance.application!=null)){
       throw new UnsupportedOperationException("The application hasn't been loaded!");
     }
   }
   
   static void setApplication(BaseGame app){
     if(instance==null){
       instance = new DataProvider();
     }
     instance.application=app;
   }

  /**
   * <p>
   * Create default instance of element with default values.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static IElement createElement() {
    checkConditions();
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
    checkConditions();
    return new Scene();
  }
  
  /**
  * <p>
  * Context of application.
  * </p> 
  * <br/>
  * @return instance of {@link Context}
  */
  public static Context getContext(){
    checkConditions();
    return instance.application.getContext();
  }

}
