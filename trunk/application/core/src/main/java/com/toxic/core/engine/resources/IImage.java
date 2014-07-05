package com.toxic.core.engine.resources;

/**
 * <p>
 * Representing image object API in this library.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface IImage {

  /**
   * <p>
   * Path to the image, relative assets.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract String getPath();

  /**
   * @return width of the image
   */
  public float getWidth();

  /**
   * @return height of the image
   */
  public float getHeight();

}
