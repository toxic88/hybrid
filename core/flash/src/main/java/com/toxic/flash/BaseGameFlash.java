/**
 * 
 */
package com.toxic.flash;

import playn.core.PlayN;
import playn.flash.FlashGame;
import playn.flash.FlashPlatform;

import com.toxic.core.engine.BaseGame;

/**
 * @author Strelock
 *
 */
public class BaseGameFlash extends FlashGame {

	@Override
    public void start() {
	    FlashPlatform platform = FlashPlatform.register();
	    
	    platform.assets().setPathPrefix("prikupa/");
	    PlayN.run(new BaseGame(new FlashContext()));
    }
}
