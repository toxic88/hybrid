package com.toxic.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;

public final class BaseApplicationJava implements IPlatform {

  private static BaseApplicationJava instance;

  private BaseApplicationJava() {
    // explicitly set private constructor
  }

  public static BaseApplicationJava getInstance() {
    if (instance == null) {
      instance = new BaseApplicationJava();
    }
    return instance;
  }

  @Override
  public void start(IApplication application) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    config.height = 720;
    config.width = 1280;
    // config.emulateTouch= true;
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new BaseApp(new JavaContext(), application));
  }
}
