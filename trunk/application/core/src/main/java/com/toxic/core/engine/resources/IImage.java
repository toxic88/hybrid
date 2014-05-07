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
   * Returns an image that draws the specified sub-region of this image.
   * 
   * @param x
   *          the x offset (in pixels) of the subimage.
   * @param y
   *          the y offset (in pixels) of the subimage.
   * @param width
   *          the width (in pixels) of the subimage.
   * @param height
   *          the height (in pixels) of the subimage.
   */
  public IImage getImage(float x, float y, float width, float height);

}
