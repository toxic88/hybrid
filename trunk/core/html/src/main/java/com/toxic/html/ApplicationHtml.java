package com.toxic.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.base.IApplication;

/**
 * <p>
 * Represent basic class of html application.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public abstract class ApplicationHtml extends HtmlGame {

  private static native int screenWidth()/*-{
		return screen.availWidth;
  }-*/;

  private static native int screenHeight()/*-{
		return screen.availHeight;
  }-*/;

  private static Element HTML_ROOT;

  protected IApplication application;
  
  /**
   * <p>
   * Default constructor. 
   * </p> 
   * <br/>
   */
  public ApplicationHtml(){
    this.setApplication();
  }
  
  /**
   * <p>
   * You should identify here {@link ApplicationHtml#application} variable; 
   * </p> 
   * <br/>
   */
  public abstract void setApplication();
  

  /**
   * <p>
   * Customize size of canvas element here... 
   * </p> 
   * <br/>
   */
  private static final void initSize() {
    // ANTS_TAG : should remade it in future to use resolution not more then
    // 1280x1024
    if (HTML_ROOT != null) {
      return;
    }
    HTML_ROOT = Document.get().createDivElement();
    HTML_ROOT.setId("playn-root");
    Document.get().getBody().appendChild(HTML_ROOT);
    HTML_ROOT.setAttribute("style", "width: " + Document.get().getBody().getOffsetWidth() + "px; height: "
      + Document.get().getBody().getOffsetHeight() + "px");
  }

  @Override
  public final void start() {
    initSize();
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // config.mode = Mode.CANVAS;
    // config.experimentalFullscreen = true;
    HtmlPlatform platForm = HtmlPlatform.register(config);
    platForm.assets().setPathPrefix("prikupa/");
    PlayN.run(new BaseApp(new PlatformHtml(this.application)));
  }

}
