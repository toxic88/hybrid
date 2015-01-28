package com.toxic.robovm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.toxic.core.engine.util.Context;

/**
 * <p> Strelock : properly document me!</p>
 * <br/>
 * @author Strelock
 *
 */
final class RoboVMContext  implements Context {

  private static final DateFormat FORMAT = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

  static {
    FORMAT.setCalendar(Calendar.getInstance());
  }
  
  public RoboVMContext() {
  }

  @Override
  public String getCurrentTime() {
    return FORMAT.format(new Date());
  }

  @Override
  public String convertMillseconds(double millsec) {
    return FORMAT.format(new Date((long) millsec));
  }

}
