package com.toxic.html;

import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;

/**
 * <p>
 * Singleton version of {@link IPlatform} instance for web's platform.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class HtmlPlatform implements IPlatform {
  
  private static IPlatform insatnce;
  
  private HtmlPlatform(){
    //explicitly set private constructor. 
  }
  
  public static IPlatform getInstance(){
    if(insatnce==null){
      insatnce = new HtmlPlatform();
    }
    return insatnce;
  }

  @Override
  public void start(IApplication application) {
    ///think up about creation and subsequent hidden transmission Context object...
  }

}
