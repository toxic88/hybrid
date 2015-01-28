package com.toxic.html;

import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;
import com.toxic.core.engine.util.Context;

/**
 * <p>
 * Html version of {@link IPlatform} instance for web's platform.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
final class PlatformHtml implements IPlatform {
  
  private final Context context = new HtmlContext();
  private final IApplication application;
  
  PlatformHtml(IApplication app){
    this.application = app;
  }
  
  @Override
  public final Context getContext() {
    return this.context;
  }

  @Override
  public final IApplication getApp() {
    return this.application;
  }

  @Override
  public final void start() {
    // Strelock : NOOP
  }
  
}
