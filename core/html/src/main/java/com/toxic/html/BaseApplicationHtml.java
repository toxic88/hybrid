package com.toxic.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.test.TestApplication;

public class BaseApplicationHtml extends HtmlGame {

  public static native int screenWidth()/*-{
		return screen.availWidth;
  }-*/;

  public static native int screenHeight()/*-{
		return screen.availHeight;
  }-*/;

  private static Element HTML_ROOT;

  public BaseApplicationHtml() {
  }

  private static void initSize() {
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
  public void start() {
    initSize();
    HtmlPlatform.Config config = new HtmlPlatform.Config();
    // config.mode = Mode.CANVAS;
    // config.experimentalFullscreen = true;
    HtmlPlatform platform = HtmlPlatform.register(config);
    platform.assets().setPathPrefix("prikupa/");
    PlayN.run(new BaseApp(new HtmlContext(), new TestApplication()));
  }

}
