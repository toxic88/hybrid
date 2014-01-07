package com.toxic.html;

import com.toxic.core.engine.test.DemoApplication;


/**
 * <p>
 *  Entry point of 'html' module.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class DemoApplicationHtml extends ApplicationHtml {

  @Override
  public void setApplication() {
    this.application = new DemoApplication();
  }


}
