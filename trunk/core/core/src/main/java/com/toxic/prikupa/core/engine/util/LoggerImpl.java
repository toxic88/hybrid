package com.toxic.prikupa.core.engine.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import playn.core.PlayN;

/**
 * @author Strelock
 * 
 */
class LoggerImpl implements Logger {

  private static final DateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");

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
  *  Create formated string of current time.
  * </p> 
  * <br/>
  * @return
  */
 private static String getFormatedTime() {
   Calendar.getInstance().setTimeInMillis((long) PlayN.currentTime());
   return format.format(Calendar.getInstance().getTime());
 }

  @Override
  public void debug(String msg, Throwable cause) {
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = " : time : " + getFormatedTime();
    }
    PlayN.log().debug("[" + LogLevel.DEBUG.toString() + " : " + this.className + currentTime + "] : " + msg, cause);
  }

  @Override
  public void info(String msg, Throwable cause) {
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = getFormatedTime();
    }
    PlayN.log().info("[" + LogLevel.INFO.toString() + " : " + this.className + " : time : " + currentTime + "] : " + msg, cause);
  }

  @Override
  public void warn(String msg, Throwable cause) {
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = getFormatedTime();
    }
    PlayN.log().warn("[" + LogLevel.WARN.toString() + " : " + this.className + " : time : " + currentTime + "] : " + msg, cause);
  }

  @Override
  public void error(String msg, Throwable cause) {
    String currentTime = "";
    if (LoggerFactory.shoudPrintTime()) {
      currentTime = getFormatedTime();
    }
    PlayN.log().error("[" + LogLevel.ERROR.toString() + " : " + this.className + " : time : " + currentTime + "] : " + msg, cause);
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
