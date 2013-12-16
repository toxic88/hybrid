/**
 * 
 */
package com.toxic.flash;

import playn.core.PlayN;
import playn.flash.FlashGame;
import playn.flash.FlashPlatform;

import com.toxic.core.engine.BaseApp;

/**
 * @author Strelock
 * 
 */
public class BaseApplicationFlash extends FlashGame {

  @Override
  public void start() {
    FlashPlatform platform = FlashPlatform.register();

    platform.assets().setPathPrefix("prikupa/");
    PlayN.run(new BaseApp(new FlashContext(), null));
  }
}
