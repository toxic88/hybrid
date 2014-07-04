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
    return "The image object has size : [" + this.image.width() + ":" + this.image.height() + "]\n"
      + "The url of image is : " + this.path;
  }

  @Override
  public String getPath() {
    return this.path;
  }

  @Override
  public IImage getSubImage(float x, float y, float width, float height) {
    if (this.image == null) {
      this.image = ResourcesLoader.getImage(this.path);
    }
    return (IImage) this.image.subImage(x, y, width, height);
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
