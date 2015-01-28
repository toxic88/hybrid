/**
 * 
 */
package com.toxic.core.engine.base;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.resources.IImage;
import com.toxic.core.engine.util.log.Logger;

/**
 * <p>
 * Responsible for behavior of background. This object could be bounded with
 * {@link IElement} through the {@link IElement#setBackGround(Background)}
 * method.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public final class Background {

  //ANTS_TAG : provide equals and hashCode functions here!

  final static Logger log = DataProvider.getLogFactory().getLogger(Background.class.getName());

  /**
   * <p>
   * For determining which flag should be interpreted for boolean
   * </p>
   * <br/>
   * 
   * @author Strelock
   * 
   */
  enum KeyType {
    REPEATX, REPEATY, RESIZE;
  }

  private final IImage image;

  private final boolean repeatX;

  private final boolean repeatY;

  private final boolean resize;

  private final int color;

  /**
   * <p>
   * Default constructor
   * </p>
   * <br/>
   */
  public Background() {
    this.image = null;
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = 0;
  }

  public Background(int bgColor) {
    this.image = null;
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = bgColor;
  }

  public Background(String path) {
    this.image = DataProvider.getImage(path);
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = 0;
  }

  public Background(String path, int bgColor) {
    this.image = DataProvider.getImage(path);
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = bgColor;
  }

  public Background(String path, int bgColor, boolean stretch) {
    this.image = DataProvider.getImage(path);
    this.repeatX = false;
    this.repeatY = false;
    this.resize = stretch;
    this.color = bgColor;
  }

  public Background(String path, boolean stretch) {
    this.image = DataProvider.getImage(path);
    this.resize = stretch;
    this.repeatX = false;
    this.repeatY = false;
    this.color = 0;
  }

  public Background(IImage imageIn) {
    this.image = imageIn;
    this.resize = true;
    this.repeatX = false;
    this.repeatY = false;
    this.color = 0;
  }

  public Background(IImage imageIn, boolean resizeIn) {
    this.image = imageIn;
    this.resize = resizeIn;
    this.repeatX = false;
    this.repeatY = false;
    this.color = 0;
  }

  private Background(Background copy, boolean flag, KeyType type) {
    this.color = copy.color;
    this.image = copy.image;
    switch (type) {

      case REPEATX:
        this.repeatX = flag;
        this.repeatY = copy.repeatY;
        this.resize = copy.resize;
        break;

      case REPEATY:
        this.repeatX = copy.repeatX;
        this.repeatY = flag;
        this.resize = copy.resize;
        break;

      case RESIZE:
        this.repeatX = copy.repeatX;
        this.repeatY = copy.repeatY;
        this.resize = flag;
        break;

      default:
        log.error("You have passed parameter to the Background constructor of " + "unprovided value : " + type);
        this.repeatX = copy.repeatX;
        this.repeatY = copy.repeatY;
        this.resize = copy.resize;
        break;
    }
  }

  private Background(Background copy, int colorIn) {
    this.color = colorIn;
    this.image = copy.image;
    this.repeatX = copy.repeatX;
    this.repeatY = copy.repeatY;
    this.resize = copy.resize;
  }

  private Background(Background copy, IImage imageIn) {
    this.color = copy.color;
    this.image = imageIn;
    this.repeatX = copy.repeatX;
    this.repeatY = copy.repeatY;
    this.resize = copy.resize;
  }

  public final boolean isRepeatX() {
    return this.repeatX;
  }

  public final Background setRepeatX(boolean repeatXIn) {
    return new Background(this, repeatXIn, KeyType.REPEATX);
  }

  public final boolean isRepeatY() {
    return this.repeatY;
  }

  public final Background setRepeatY(boolean repeatYIn) {
    return new Background(this, repeatYIn, KeyType.REPEATY);
  }

  public final boolean isResize() {
    return this.resize;
  }

  public final Background setResize(boolean resizeIn) {
    return new Background(this, resizeIn, KeyType.RESIZE);
  }

  public final IImage getImage() {
    return this.image;
  }

  public final Background setImage(IImage image) {
    return new Background(this, image);
  }

  public final int getColor() {
    return this.color;
  }

  public final Background setColor(int color) {
    return new Background(this, color);
  }

  @Override
  public String toString() {
    return "BackgroundObject[image=" + this.image + ",repeatX=" + this.repeatX + ",repeatY=" + this.repeatY
      + ",resize=" + this.resize + ",color=" + Integer.toHexString(this.color) + "].";
  }

}
