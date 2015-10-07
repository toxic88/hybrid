package com.toxic.core.engine.resources;

import com.toxic.core.engine.base.IElement;

/**
 * <p>
 * Represent text formating(behavior) on certain element. You can bind it
 * through the method : {@link IElement#setTextFormat(TextFormat)} .
 * </p>
 * <br/>
 * @author Strelock
 */
public interface ITextFormat {

    /**
     * @return integer representation of color by HEX pattern 0xAARRGGBB
     */
    public abstract int getColor();

    /**
     * <p>
     * Set margin of certain element.
     * </p>
     * <br/>
     * @param top margin for top of bind element
     * @param right margin for right of bind element
     * @param bottom margin for bottom of bind element
     * @param left margin for left of bind element
     */
    public abstract void setMargin(float top, float right, float bottom, float left);

    /**
     * <p>
     * Set margin of certain element.
     * </p>
     * <br/>
     * @param horizontal margin for top and bottom of bind element
     * @param vertical margin for right and left of bind element
     */
    public abstract void setMargin(float horizontal, float vertical);

    /**
     * @return value of margin top
     */
    public abstract float getMarginTop();

    /**
     * @return  value of margin right
     */
    public abstract float getMarginRight();

    /**
     * @return value of margin bottom
     */
    public abstract float getMarginBottom();

    /**
     * @return value of margin left
     */
    public abstract float getMarginLeft();

}
