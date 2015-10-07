package com.toxic.core.engine;

import playn.core.TextFormat.Alignment;

import com.toxic.core.engine.resources.IFont;
import com.toxic.core.engine.resources.ITextFormat;

/**
 * <p>
 *   Encapsulated implementation of {@link ITextFormat}.
 * </p>
 * <br/>
 * @author Strelock
 */
final class TextFormat implements ITextFormat {

  // Strelock : implement fully margin and create auto-sizing layout.

  private final playn.core.TextFormat textFormat;
  private final int color;
  private float marginTop = 0;
  private float marginRight = 0;
  private float marginBottom = 0;
  private float marginLeft = 0;

  /**
   * Default constructor.
   */
  public TextFormat() {
    this.textFormat = new playn.core.TextFormat();
    this.color = 0xFFFFFFFF;
  }

  /**
   * Default constructor.
   */
  public TextFormat(int textColor) {
    this.textFormat = new playn.core.TextFormat();
    this.color = textColor;
  }

  public TextFormat(IFont font) {
    this.textFormat = new playn.core.TextFormat(((TextFont) font).getFont(), Float.MAX_VALUE, Alignment.LEFT);
    this.color = 0xFFFFFFFF;
  }

  public TextFormat(IFont font, int textColor) {
    this.textFormat = new playn.core.TextFormat(((TextFont) font).getFont(), Float.MAX_VALUE, Alignment.LEFT);
    this.color = textColor;
  }

  public TextFormat(Alignment align) {
    this.textFormat = new playn.core.TextFormat(null, Float.MAX_VALUE, align);
    this.color = 0xFFFFFFFF;
  }

  public TextFormat(Alignment align, int textColor) {
    this.textFormat = new playn.core.TextFormat(null, Float.MAX_VALUE, align);
    this.color = textColor;
  }

  public TextFormat(IFont font, Alignment align) {
    this.textFormat = new playn.core.TextFormat(((TextFont) font).getFont(), Float.MAX_VALUE, align);
    this.color = 0xFFFFFFFF;
  }

  public TextFormat(IFont font, Alignment align, int textColor) {
    this.textFormat = new playn.core.TextFormat(((TextFont) font).getFont(), Float.MAX_VALUE, align);
    this.color = textColor;
  }

  playn.core.TextFormat getFormat() {
    return this.textFormat;
  }

  public TextFormat(IFont font, float wrapWidth, Alignment align) {
    this.textFormat = new playn.core.TextFormat(((TextFont) font).getFont(), wrapWidth, align);
    this.color = 0xFFFFFFFF;
  }

  @Override
  public int getColor() {
    return this.color;
  }

  @Override
  public void setMargin(float top, float right, float bottom, float left) {
    this.marginTop = top;
    this.marginRight = right;
    this.marginBottom = bottom;
    this.marginLeft = left;
  }

  @Override
  public void setMargin(float horizontal, float vertical) {
    this.marginTop = vertical;
    this.marginRight = horizontal;
    this.marginBottom = vertical;
    this.marginLeft = horizontal;
  }

  @Override
  public float getMarginTop() {
    return this.marginTop;
  }

  @Override
  public float getMarginRight() {
    return this.marginRight;
  }

  @Override
  public float getMarginBottom() {
    return this.marginBottom;
  }

  @Override
  public float getMarginLeft() {
    return this.marginLeft;
  }

  boolean isMargin() {
    return !(this.marginTop == 0 && this.marginRight == 0 && this.marginBottom == 0 && this.marginLeft == 0);
  }

}
