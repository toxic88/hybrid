package com.toxic.core.engine;

import com.toxic.core.engine.util.log.LogFactory;
import com.toxic.core.engine.util.log.LogLevel;
import com.toxic.core.engine.util.log.Logger;

import playn.core.Log.Level;
import playn.core.PlayN;

/**
 * <p>
 *  Implementation of log factory.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
class LoggerFactory implements LogFactory {

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

  @Override
  public void setLogLevel(LogLevel logLevel) {
    if (logLevel == null) {
      throw new IllegalArgumentException("You have specified empty log level!");
    }
    get().level = logLevel;
  }

  @Override
  public void setPrintTime(boolean flag) {
    get().shouldPrintTime = flag;
  }
  
  @Override
  public Logger getLogger(String className){
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
