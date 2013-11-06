/**
 * 
 */
package com.toxic.prikupa.flash;

import playn.core.PlayN;
import playn.flash.FlashGame;
import playn.flash.FlashPlatform;

import com.toxic.prikupa.core.PrikupaGame;

/**
 * @author Strelock
 *
 */
public class PrikupaGameFlash extends FlashGame {

	@Override
    public void start() {
	    FlashPlatform platform = FlashPlatform.register();
	    
	    platform.assets().setPathPrefix("prikupa/");
	    PlayN.run(new PrikupaGame());
    }
}
