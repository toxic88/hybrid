package com.toxic.prikupa.core.engine.util;


/**
 * <p>
 * Represent the global application context, for utility and useful object sharing.
 * </p>
 * <br/>
 * 
 * @author Strelock
 *
 */
public interface Context {

  /**
   *
   * <p>
   * Current representation of time in the pattern : HH:mm:sss
   * </p> 
   * <br/>
   * @return
   */
  public abstract String getCurrentTime();
  
  /**
   *
   * <p>
   * Formated representation of time in the pattern : HH:mm:sss
   * </p> 
   * <br/>
   * @param millsec amount of milliseconds till 1970s
   * @return
   */
  public abstract String convertMillseconds(double millsec);

}
