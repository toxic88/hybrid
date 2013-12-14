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

  private BaseGame application;

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

  static void setApplication(BaseGame app) {
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

}
