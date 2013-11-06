package com.toxic.prikupa.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.toxic.prikupa.core.PrikupaGame;

public class PrikupaGameJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    config.height=720;
    config.width=1280;
//    config.emulateTouch= true;
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new PrikupaGame());
  }
}
