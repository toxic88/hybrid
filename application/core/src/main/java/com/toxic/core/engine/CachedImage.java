/**
 * 
 */
package com.toxic.core.engine;

import playn.core.Image;

import com.toxic.core.engine.resources.IImage;

/**
 * <p>
 * Encapsulated instance of image object.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
final class CachedImage implements IImage {

  private final String path;
  private Image image;

  private CachedImage(String s, Image im) {
    this.path = s;
    this.image = im;
  }

  static CachedImage build(String path) {
    return new CachedImage(path, ResourcesLoader.getImage(path));
  }

  static CachedImage build(String path, float offsetX, float offsetY, float width, float height) {
    return new CachedImage(path, ResourcesLoader.getImage(path).subImage(offsetX, offsetY, width, height));
  }

  void releaseImage() {
    ResourcesLoader.release(this.path);
    this.image = null;
  }

  Image getImage() {
    if (this.image == null) {
      this.image = ResourcesLoader.getImage(this.path);
    }
    return this.image;
  }

  @Override
  public String toString() {
    if (this.image==null) {
      return "EMTY IMAGE!!! URL=["+this.path+"].";
    }
    return "Image:[size=[" + this.image.width() + "x" + this.image.height() + "] "
      + "URL=[" + this.path + "].";
  }

  @Override
  public String getPath() {
    return this.path;
  }

  @Override
  public float getWidth() {
    return this.image.width();
  }

  @Override
  public float getHeight() {
    return this.image.height();
  }

}
