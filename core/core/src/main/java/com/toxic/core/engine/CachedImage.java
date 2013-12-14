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
class CachedImage implements IImage {

  private final String path;
  private Image image;

  private CachedImage(String s, Image im) {
    this.path = s;
    this.image = im;
  }

  static CachedImage build(String path) {
    return new CachedImage(path, Resources.getImage(path));
  }

  void releaseImage() {
    Resources.release(this.path);
    this.image = null;
  }

  Image getImage() {
    if (this.image == null) {
      this.image = Resources.getImage(this.path);
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

}
