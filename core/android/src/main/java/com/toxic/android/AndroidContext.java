package com.toxic.android;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toxic.core.engine.util.Context;

/**
 * <p></p>
 * <br/>
 * @author Strelock
 *
 */
class AndroidContext implements Context {
  
  private static final DateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");

  static {
    format.setCalendar(Calendar.getInstance());
  }

  @Override
  public String getCurrentTime() {
    return format.format(new Date());
  }

  @Override
  public String convertMillseconds(double millsec) {
    return format.format(new Date((long) millsec));
  }

}
