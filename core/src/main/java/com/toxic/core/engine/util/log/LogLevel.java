package com.toxic.core.engine.util.log;


/**
 * <p>
 * Determines order of {@link Logger}'s printing messages. To set level of
 * logging use {@link LoggerFactory#setLogLevel(LogLevel)} with appropriate
 * logging level from this class.
 * </p>
 * <br/>
 * @author Strelock
 */
public enum LogLevel {

  /**
   * Most lower level of logger, all of the messages will be printed.
   */
  DEBUG("DEBUG",0),
  
  /**
   * The info and error messages will be printed.
   */
  INFO("INFO",1),
  
  /**
   * The warnings, info and error messages will be printed.
   */
  WARN("WARN",2),
  
  /**
   * Most upper level, it is exist minimum value. The error messages will be printed.
   */
  ERROR("ERROR",3);

  private final int level;
  private final String name;

  private LogLevel(String name,int value) {
    this.name=name;
    this.level = value;
  }

  /**
   * <p>
   * Allows compare {@link LogLevel}.
   * </p>
   * <br/>
   * @return corresponding value binding to this {@link LogLevel}
   */
  public int getLevelCount() {
    return this.level;
  }
  
  @Override
  public String toString(){
    return this.name;
  }

}
