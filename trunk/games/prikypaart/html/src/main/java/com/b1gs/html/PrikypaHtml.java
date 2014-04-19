package com.b1gs.html;

import com.b1gs.core.Prikypa;
import com.toxic.html.ApplicationHtml;


/**
 * <p>
 *  Entry point of 'html' module.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class PrikypaHtml extends ApplicationHtml {

  @Override
  public void setApplication() {
    this.application = new Prikypa();
  }


}
