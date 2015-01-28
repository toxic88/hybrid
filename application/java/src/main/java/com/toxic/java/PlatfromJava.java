package com.toxic.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;
import com.toxic.core.engine.util.Context;

/**
 * <p></p>
 * <br/>
 * @author Strelock
 *
 */
public class PlatfromJava implements IPlatform {

  private final Context context = new JavaContext();
  protected IApplication application;

  /**
   * <p>
   * Default hidden constructor
   * </p>
   * <br/>
   * 
   * @param app
   *          executed instance of application.
   */
  protected PlatfromJava(IApplication app) {
    this.application = app;
  }

  @Override
  public final IApplication getApp() {
    return this.application;
  }

  @Override
  public final Context getContext() {
    return this.context;
  }

  /**
   * <p>
   * Start game launching.
   * </p>
   */
  public final void start() {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // Strelock : JAVA_RESOLUTION!
    config.height = 720;
    config.width = 1280;
    // config.emulateTouch= true;
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new BaseApp(this));
  }
}
