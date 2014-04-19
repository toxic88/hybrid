package com.b1gs.android;

import com.toxic.android.PlatfromAndroid;
import com.b1gs.core.Prikypa;


/**
 * <p>Example of executing android application.</p>
 * <br/>
 * @author Strelock
 *
 */
public class PrikypaAndroid extends PlatfromAndroid {

  @Override
  public void setApplication() {
    this.application = new Prikypa();
  }

}
