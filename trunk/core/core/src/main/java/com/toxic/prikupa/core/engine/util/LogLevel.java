/**
 * 
 */
package com.toxic.prikupa.core.engine.util;

/**
 * <p>
 * Determines order of {@link Logger}'s printing messages. To set level of
 * logging use {@link LoggerFactory#setLogLevel(LogLevel)} with appropriate
 * logging level from this class.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public enum LogLevel {

  /**
   * <p>
   * Most lower level of logger, all of the messages will be printed.
   * </p>
   * <br/>
   */
  DEBUG(0),
  /**
   * <p>
   * The info and error messages will be printed.
   * </p>
   * <br/>
   */
  INFO(1),
  /**
   * <p>
   * The warnings, info and error messages will be printed.
   * </p>
   * <br/>
   */
  WARN(2),
  /**
   * <p>
   * Most upper level, it is exist minimum value. The error messages will be
   * printed.
   * </p>
   * <br/>
   */
  ERROR(3);

  private final int level;

  private LogLevel(int value) {
    this.level = value;
  }

  /**
   * <p>
   * Allows compare {@link LogLevel}.
   * </p>
   * <br/>
   * 
   * @return corresponding value binding to this {@link LogLevel}
   */
  public int getLevelCount() {
    return this.level;
  }

}
