package com.toxic.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.toxic.core.engine.BaseGame;

public class BaseGameJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    config.height=720;
    config.width=1280;
//    config.emulateTouch= true;
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new BaseGame(new JavaContext()));
  }
}
