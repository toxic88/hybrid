package com.toxic.ui.android;

import com.toxic.android.PlatfromAndroid;
import com.toxic.ui.core.ShowCase;


/**
 * <p>Example of executing android application.</p>
 * <br/>
 * @author Strelock
 *
 */
public class ShowCaseAndroid extends PlatfromAndroid {

  @Override
  public void setApplication() {
    this.application = new ShowCase();
  }

}
