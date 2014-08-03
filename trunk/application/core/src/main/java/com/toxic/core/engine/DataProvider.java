package com.toxic.core.engine;

import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;

import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.resources.IFont;
import com.toxic.core.engine.resources.IImage;
import com.toxic.core.engine.resources.ITextFormat;
import com.toxic.core.engine.util.AppTimer;
import com.toxic.core.engine.util.Context;
import com.toxic.core.engine.util.log.LogFactory;
import com.toxic.core.engine.util.log.Logger;

/**
 * <p>
 * Through this object you can create almost all library object.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
/**
 * @author Strelock
 * 
 */
public class DataProvider {

  private static DataProvider instance;

  private BaseApp application;

  private DataProvider() {
    // NOP
  }

  /**
   * <p>
   * Weather game has been properly loaded.
   * </p>
   * <br/>
   * 
   * @return
   */
  private static void checkConditions() {
    if (!(instance != null && instance.application != null)) {
      throw new UnsupportedOperationException("The application hasn't been loaded!");
    }
  }

  static void setApplication(BaseApp app) {
    if (instance == null) {
      instance = new DataProvider();
    }
    instance.application = app;
  }

  /**
   * <p>
   * Create default instance of element with default values.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static IElement createElement() {
    checkConditions();
    return new BaseElement();
  }

  /**
   * <p>
   * Create {@link IScene} with default parameters.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static IScene createScene() {
    checkConditions();
    return new Scene();
  }

  /**
   * <p>
   * Create instance of {@link IFont}.
   * </p>
   * <br/>
   * 
   * @param id
   *          {@link String} identifier of element
   * @param style
   *          {@link Style} of font text
   * @param size
   *          size of font
   * @return {@link IFont} object
   */
  public static IFont createFont(String id, Style style, float size) {
    return new TextFont(id, style, size);
  }

  /**
   * <p>
   * Create instance of {@link IFont}.
   * </p>
   * <br/>
   * 
   * @param id
   *          {@link String} identifier of element
   * @param style
   *          {@link Style} of font text
   * @param size
   *          size of font
   * @return {@link IFont} object
   */
  public static ITextFormat createTextFormat(IFont font, Alignment alignment) {
    return new TextFormat(font, alignment);
  }

  /**
   * <p>
   * Create instance of {@link IFont}.
   * </p>
   * <br/>
   * 
   * @param id
   *          {@link String} identifier of element
   * @param style
   *          {@link Style} of font text
   * @param color
   *          integer value like 0xAARRGGBB
   * @return {@link IFont} object
   */
  public static ITextFormat createTextFormat(IFont font, Alignment align, int textColor) {
    return new TextFormat(font, align, textColor);
  }

  /**
   * <p>
   * Context of application.
   * </p>
   * <br/>
   * 
   * @return instance of {@link Context}
   */
  public static Context getContext() {
    checkConditions();
    return instance.application.getContext();
  }

  /**
   * <p>
   * Returns instance of {@link AppTimer}.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static AppTimer getTimer() {
    checkConditions();
    return TimerUtility.getInstance();
  }

  /**
   * <p>
   * Return {@link LogFactory} instance for creating
   * {@link LogFactory#getLogger(String)} instance of {@link Logger} for
   * specified class.
   * </p>
   * <br/>
   * 
   * @return
   */
  public static LogFactory getLogFactory() {
    checkConditions();
    return LoggerFactory.get();
  }

  /**
   * <p>
   * Load image from specified path.
   * </p>
   * <br/>
   * 
   * @param path
   *          location of image relative assets
   * @return {@link IImage} instance
   */
  public static IImage getImage(String path) {
    checkConditions();
    return CachedImage.build(path);
  }

  /**
   * <p>
   * Load sub image from specified path with params
   * </p>
   * 
   * @param path
   *          - image path
   * @param offsetX
   *          - x axis offset
   * @param offsetY
   *          - y axis offset
   * @param width
   *          - sub image width
   * @param height
   *          - sub image height
   * @return subImage of image from path
   */
  public static IImage getImage(String path, float offsetX, float offsetY, float width, float height) {
    checkConditions();
    return CachedImage.build(path, offsetX, offsetY, width, height);
  }

  /**
   * 
   * @return Instance of {@link IEventManager}
   */
  public static IEventManager getEventManager() {
    return EventManager.getInstanse();
  }

}
