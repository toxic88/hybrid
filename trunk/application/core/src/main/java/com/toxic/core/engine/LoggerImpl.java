package com.toxic.core.engine;

import playn.core.PlayN;

import com.toxic.core.engine.util.log.LogLevel;
import com.toxic.core.engine.util.log.Logger;

/**
 * @author Strelock
 * 
 */
final class LoggerImpl implements Logger {

  private final String className;

  /**
   * 
   * <p>
   * Create instance of logger for corresponding class. This input string will
   * be print as prefix for print process through the usage of this instance
   * </p>
   * <br/>
   */
  LoggerImpl(String className) {
    this.className = className;
  }

  /**
   * <p>
   * Create formated string of current time.
   * </p>
   * <br/>
   * 
   * @return
   */
  private static String getFormatedTime() {
    return DataProvider.getContext().getCurrentTime();
  }

  /**
   * <p>
   * Weather corresponding level equals or greater then global logging level.
   * </p>
   * <br/>
   * 
   * @param level
   * @return
   */
  private static boolean checkConditions(LogLevel level) {
    return (LoggerFactory.getGlobalLevel().getLevelCount() <= level.getLevelCount());
  }

  @Override
  public void debug(String msg, Throwable cause) {
    if (!(checkConditions(LogLevel.DEBUG))) {
      return;
    }
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = " : time : " + getFormatedTime();
    }
    PlayN.log().debug("[" + LogLevel.DEBUG.toString() + " : " + this.className + currentTime + "] : " + msg, cause);
  }

  @Override
  public void info(String msg, Throwable cause) {
    if (!(checkConditions(LogLevel.INFO))) {
      return;
    }
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = getFormatedTime();
    }
    PlayN.log().info(
      "[" + LogLevel.INFO.toString() + " : " + this.className + " : time : " + currentTime + "] : " + msg, cause);
  }

  @Override
  public void warn(String msg, Throwable cause) {
    if (!(checkConditions(LogLevel.WARN))) {
      return;
    }
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = getFormatedTime();
    }
    PlayN.log().warn(
      "[" + LogLevel.WARN.toString() + " : " + this.className + " : time : " + currentTime + "] : " + msg, cause);
  }

  @Override
  public void error(String msg, Throwable cause) {
    if (!(checkConditions(LogLevel.ERROR))) {
      return;
    }
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = getFormatedTime();
    }
    PlayN.log().error(
      "[" + LogLevel.ERROR.toString() + " : " + this.className + " : time : " + currentTime + "] : " + msg, cause);
  }

  @Override
  public void debug(String msg) {
    this.debug(msg, null);
  }

  @Override
  public void info(String msg) {
    this.info(msg, null);
  }

  @Override
  public void warn(String msg) {
    this.warn(msg, null);
  }

  @Override
  public void error(String msg) {
    this.error(msg, null);
  }

}
