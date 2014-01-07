/**
 * 
 */
package com.toxic.flash;

import playn.core.PlayN;
import playn.flash.FlashGame;
import playn.flash.FlashPlatform;

import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;
import com.toxic.core.engine.util.Context;

/**
 * <p>Unsupported project...maybe will be removed in future.</p>
 * <br/>
 * @author Strelock
 * 
 */
public class BaseApplicationFlash extends FlashGame {

  @Override
  public void start() {
    FlashPlatform platform = FlashPlatform.register();

    platform.assets().setPathPrefix("prikupa/");
    PlayN.run(new BaseApp(new IPlatform() {
      
      @Override
      public Context getContext() {
        return null;
      }
      
      @Override
      public IApplication getApp() {
        return null;
      }
    }));
  }
}
