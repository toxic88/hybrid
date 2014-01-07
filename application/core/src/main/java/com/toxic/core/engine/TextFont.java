package com.toxic.core.engine;

import playn.core.Font;
import playn.core.PlayN;
import playn.core.Font.Style;

import com.toxic.core.engine.resources.IFont;

/**
 * <p>
 * Encapsulated object of {@link IFont}.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
class TextFont implements IFont {

  private final Font playNFont;

  /**
   * <p>
   * Default constructor.
   * </p>
   * <br/>
   * 
   * @param id
   * @param style
   * @param size
   */
  TextFont(String id, Style style, float size) {
    this.playNFont = PlayN.graphics().createFont(id, style, size);
  }

  /**
   * <p>
   * Encapsulated method of font.
   * </p>
   * <br/>
   * 
   * @return
   */
  Font getFont() {
    return this.playNFont;
  }
  
  @Override
  public String getId(){
    return this.playNFont.name();
  }

  @Override
  public float getSize() {
    return this.playNFont.size();
  }

  @Override
  public Style getStyle() {
    return this.playNFont.style();
  }
  
  

}
