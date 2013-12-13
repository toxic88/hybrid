/**
 * 
 */
package com.toxic.core.engine;

import playn.core.Image;

/**
 * @author Strelock
 * 
 */
public class CachedImage {

  private final String path;
  private Image image;

  private CachedImage(String s, Image im) {
    this.path = s;
    this.image = im;
  }

  public static CachedImage build(String path) {
    return new CachedImage(path, Resources.getImage(path));
  }

  public void releaseImage() {
    Resources.release(this.path);
    this.image = null;
  }

  public Image getImage() {
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

  public String getPath() {
    return this.path;
  }

}
