package com.toxic.prikupa.android;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toxic.prikupa.core.engine.util.Context;

/**
 * @author Strelock
 *
 */
public class AndroidContext implements Context {
  
  private static final DateFormat format = new SimpleDateFormat("HH:mm:ss:SSS");

  static {
    format.setCalendar(Calendar.getInstance());
  }

  @Override
  public String getCurrentTime() {
    return format.format(new Date());
  }

  @Override
  public String convertMillseconds(float millsec) {
    return format.format(new Date((long) millsec));
  }

}
