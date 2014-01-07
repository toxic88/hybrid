package com.toxic.core.engine.resources;

import playn.core.Font.Style;

/**
 * <p>
 * Represent font element.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface IFont {

  /**
   * @return the {@link String} identifier of this font element.
   */
  public abstract String getId();

  /**
   * @return size of this font element.
   */
  public abstract float getSize();

  /**
   * @return the {@link Style} element of this font element.
   */
  public abstract Style getStyle();

}
