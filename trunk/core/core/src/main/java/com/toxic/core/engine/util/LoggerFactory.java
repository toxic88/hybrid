package com.toxic.core.engine.util;

import playn.core.Log.Level;
import playn.core.PlayN;

/**
 * <p>
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public class LoggerFactory {

  private static LoggerFactory instance;

  LogLevel level ;

  boolean shouldPrintTime = false;

  /**
   * <p>
   * Hidden single constructor, for preventing of corruption.
   * </p>
   * <br/>
   */
  private LoggerFactory() {
    PlayN.log().setMinLevel(Level.DEBUG);
  }
  
  /**
   * <p>
   * Initializing method. 
   * </p> 
   * <br/>
   * @return
   */
  static LoggerFactory get(){
    if(instance==null){
      instance= new LoggerFactory();
    }
    return instance;
  }

  /**
   * <p>
   * Setting global logic level, to prevent print less of settled level
   * messages.
   * </p>
   * <br/>
   * 
   * @param logLevel
   */
  public static void setLogLevel(LogLevel logLevel) {
    if (logLevel == null) {
      throw new IllegalArgumentException("You have specified empty log level!");
    }
    get().level = logLevel;
  }

  /**
   * <p>
   * Determines weather logging process should also contains time of printing
   * message.
   * </p>
   * <br/>
   * <b>By default : false .</b> <br/>
   * 
   * @param flag
   */
  public static void setPrintTime(boolean flag) {
    get().shouldPrintTime = flag;
  }
  
  /**
   * <p>
   * Return logger for corresponding className
   * </p> 
   * <br/>
   * @param className
   * @return
   */
  public static Logger getLogger(String className){
    if(className== null || className.trim().isEmpty()){
      throw new IllegalArgumentException("You have tried create logger of empty class!");
    }
    return new LoggerImpl(className);
  }

  /**
   * <p>
   * Allows determine global logging Level.
   * </p>
   * <br/>
   * 
   * @return
   */
  static LogLevel getGlobalLevel() {
    return get().level;
  }

  /**
   * <p>
   * Allows determine global logging Level.
   * </p>
   * <br/>
   * 
   * @return
   */
  static boolean shoudPrintTime() {
    return get().shouldPrintTime;
  }

}
