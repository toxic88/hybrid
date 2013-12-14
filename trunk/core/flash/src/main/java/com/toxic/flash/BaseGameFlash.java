/**
 * 
 */
package com.toxic.flash;

import playn.core.PlayN;
import playn.flash.FlashGame;
import playn.flash.FlashPlatform;

import com.toxic.core.engine.BaseGame;
import com.toxic.core.engine.base.IApplication;

/**
 * @author Strelock
 * 
 */
public class BaseGameFlash extends FlashGame {

  @Override
  public void start() {
    FlashPlatform platform = FlashPlatform.register();

    platform.assets().setPathPrefix("prikupa/");
    PlayN.run(new BaseGame(new FlashContext(), new IApplication() {

      @Override
      public void update(int delta) {
        // NOOP
      }

      @Override
      public void init() {
        // NOOP
      }
    }));
  }
}
