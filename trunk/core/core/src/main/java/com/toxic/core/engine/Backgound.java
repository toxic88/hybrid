/**
 * 
 */
package com.toxic.core.engine;

import com.toxic.core.engine.util.Logger;
import com.toxic.core.engine.util.LoggerFactory;

/**
 * @author Strelock
 * 
 */
public final class Backgound {
  
  final static Logger log = LoggerFactory.getLogger(Backgound.class.getName());

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

  private final CachedImage image;

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
  public Backgound() {
    this.image = null;
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = 0;
  }

  public Backgound(int bgColor) {
    this.image = null;
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = bgColor;
  }

  public Backgound(String path) {
    this.image = CachedImage.build(path);
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = 0;
  }

  public Backgound(String path, int bgColor) {
    this.image = CachedImage.build(path);
    this.repeatX = false;
    this.repeatY = false;
    this.resize = true;
    this.color = bgColor;
  }

  public Backgound(String path, int bgColor, boolean stretch) {
    this.image = CachedImage.build(path);
    this.repeatX = false;
    this.repeatY = false;
    this.resize = stretch;
    this.color = bgColor;
  }

  public Backgound(String path, boolean stretch) {
    this.image = CachedImage.build(path);
    this.resize = stretch;
    this.repeatX = false;
    this.repeatY = false;
    this.color = 0;
  }

  public Backgound(CachedImage imageIn) {
    this.image = imageIn;
    this.resize = true;
    this.repeatX = false;
    this.repeatY = false;
    this.color = 0;
  }

  public Backgound(CachedImage imageIn, boolean resizeIn) {
    this.image = imageIn;
    this.resize = resizeIn;
    this.repeatX = false;
    this.repeatY = false;
    this.color = 0;
  }

  private Backgound(Backgound copy, boolean flag, KeyType type) {
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

  private Backgound(Backgound copy, int colorIn) {
    this.color = colorIn;
    this.image = copy.image;
    this.repeatX = copy.repeatX;
    this.repeatY = copy.repeatY;
    this.resize = copy.resize;
  }

  private Backgound(Backgound copy, CachedImage imageIn) {
    this.color = copy.color;
    this.image = imageIn;
    this.repeatX = copy.repeatX;
    this.repeatY = copy.repeatY;
    this.resize = copy.resize;
  }

  public final boolean isRepeatX() {
    return this.repeatX;
  }

  public final Backgound setRepeatX(boolean repeatXIn) {
    return new Backgound(this, repeatXIn, KeyType.REPEATX);
  }

  public final boolean isRepeatY() {
    return this.repeatY;
  }

  public final Backgound setRepeatY(boolean repeatYIn) {
    return new Backgound(this, repeatYIn, KeyType.REPEATY);
  }

  public final boolean isResize() {
    return this.resize;
  }

  public final Backgound setResize(boolean resizeIn) {
    return new Backgound(this, resizeIn, KeyType.RESIZE);
  }

  public final CachedImage getImage() {
    return this.image;
  }

  public final Backgound setImage(CachedImage image) {
    return new Backgound(this, image);
  }

  public final int getColor() {
    return this.color;
  }

  public final Backgound setColor(int color) {
    return new Backgound(this, color);
  }

}
