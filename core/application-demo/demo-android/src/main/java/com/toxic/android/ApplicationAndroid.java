package com.toxic.android;

import com.toxic.core.engine.test.DemoApplication;


/**
 * <p>Example of executing android application.</p>
 * <br/>
 * @author Strelock
 *
 */
public class ApplicationAndroid extends PlatfromAndroid {

  @Override
  public void setApplication() {
    this.application = new DemoApplication();
  }

}
