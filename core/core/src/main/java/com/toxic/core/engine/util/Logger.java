package com.toxic.core.engine.util;

/**
 * <p>
 * This utility class represents {@link Logger} instance, that has possibility
 * printing message with several
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface Logger {

  /**
   * 
   * <p>
   * Print debug's message with corresponding cause.
   * </p>
   * <br/>
   * 
   * @param msg
   * @param cause
   */
  public abstract void debug(String msg, Throwable cause);

  /**
   * 
   * <p>
   * Print information message with corresponding cause.
   * </p>
   * <br/>
   * 
   * @param msg
   * @param cause
   */
  public abstract void info(String msg, Throwable cause);

  /**
   * 
   * <p>
   * Print wrining's message with corresponding cause.
   * </p>
   * <br/>
   * 
   * @param msg
   * @param cause
   */
  public abstract void warn(String msg, Throwable cause);

  /**
   * 
   * <p>
   * Print error's message with corresponding cause.
   * </p>
   * <br/>
   * 
   * @param msg
   * @param cause
   */
  public abstract void error(String msg, Throwable cause);
  
  /**
   * 
   * <p>
   * Print debug's message.
   * </p>
   * <br/>
   * 
   * @param msg
   */
  public abstract void debug(String msg);

  /**
   * 
   * <p>
   * Print information message.
   * </p>
   * <br/>
   * 
   * @param msg
   */
  public abstract void info(String msg);

  /**
   * 
   * <p>
   * Print wrining's message.
   * </p>
   * <br/>
   * 
   * @param msg
   */
  public abstract void warn(String msg);

  /**
   * 
   * <p>
   * Print error's message.
   * </p>
   * <br/>
   * 
   * @param msg
   */
  public abstract void error(String msg);

}
