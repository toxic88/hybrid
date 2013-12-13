/**
 * 
 */
package com.toxic.core.engine;

import playn.core.Font;
import playn.core.TextFormat.Alignment;

/**
 * @author Strelock
 * 
 */
public class TextFormat {

  // ANTS_TAG : implement fully margin and create auto-sizing layout.

  private final playn.core.TextFormat textFormat;
  private final int color;
  private float marginTop = 0;
  private float marginRight = 0;
  private float marginBottom = 0;
  private float marginLeft = 0;

  /**
   * <p>
   * Default constructor.
   * </p>
   * <br/>
   */
  public TextFormat() {
    this.textFormat = new playn.core.TextFormat();
    this.color = 0xFFFFFFFF;
  }

  /**
   * <p>
   * Default constructor.
   * </p>
   * <br/>
   */
  public TextFormat(int textColor) {
    this.textFormat = new playn.core.TextFormat();
    this.color = textColor;
  }

  /**
   * <p>
   * </p>
   * <br/>
   */
  public TextFormat(Font font) {
    this.textFormat = new playn.core.TextFormat(font, Float.MAX_VALUE, Alignment.LEFT);
    this.color = 0xFFFFFFFF;
  }

  /**
   * <p>
   * </p>
   * <br/>
   */
  public TextFormat(Font font, int textColor) {
    this.textFormat = new playn.core.TextFormat(font, Float.MAX_VALUE, Alignment.LEFT);
    this.color = textColor;
  }

  /**
   * <p>
   * </p>
   * <br/>
   */
  public TextFormat(Alignment align) {
    this.textFormat = new playn.core.TextFormat(null, Float.MAX_VALUE, align);
    this.color = 0xFFFFFFFF;
  }

  /**
   * <p>
   * </p>
   * <br/>
   */
  public TextFormat(Alignment align, int textColor) {
    this.textFormat = new playn.core.TextFormat(null, Float.MAX_VALUE, align);
    this.color = textColor;
  }

  /**
   * <p>
   * </p>
   * <br/>
   */
  public TextFormat(Font font, Alignment align) {
    this.textFormat = new playn.core.TextFormat(font, Float.MAX_VALUE, align);
    this.color = 0xFFFFFFFF;
  }

  /**
   * <p>
   * </p>
   * <br/>
   */
  public TextFormat(Font font, Alignment align, int textColor) {
    this.textFormat = new playn.core.TextFormat(font, Float.MAX_VALUE, align);
    this.color = textColor;
  }

  playn.core.TextFormat getFormat() {
    return this.textFormat;
  }

  /**
   * <p>
   * 
   * </p>
   * <br/>
   */
  public TextFormat(Font font, float wrapWidth, Alignment align) {
    this.textFormat = new playn.core.TextFormat(font, wrapWidth, align);
    this.color = 0xFFFFFFFF;
  }

  public int getColor() {
    return this.color;
  }

  public void setMargin(float top, float right, float bottom, float left) {
    this.marginTop = top;
    this.marginRight = right;
    this.marginBottom = bottom;
    this.marginLeft = left;
  }

  public void setMargin(float horizontal, float vertical) {
    this.marginTop = vertical;
    this.marginRight = horizontal;
    this.marginBottom = vertical;
    this.marginLeft = horizontal;
  }

  public float getMarginTop() {
    return this.marginTop;
  }

  public float getMarginRight() {
    return this.marginRight;
  }

  public float getMarginBottom() {
    return this.marginBottom;
  }

  public float getMarginLeft() {
    return this.marginLeft;
  }

  boolean isMargin() {
    return !(this.marginTop == 0 && this.marginRight == 0 && this.marginBottom == 0 && this.marginLeft == 0);
  }

}
