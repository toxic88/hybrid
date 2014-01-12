package com.toxic.ui.html;

import com.toxic.ui.core.ShowCase;
import com.toxic.html.ApplicationHtml;


/**
 * <p>
 *  Entry point of 'html' module.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class ShowCaseHtml extends ApplicationHtml {

  @Override
  public void setApplication() {
    this.application = new ShowCase();
  }


}
