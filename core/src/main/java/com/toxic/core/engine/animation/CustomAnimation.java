package com.toxic.core.engine.animation;

import com.toxic.core.engine.base.IElement;

/**
 * <p>
 * Allows create custom animation, that will be handle {@link IElement}. To bind
 * object use
 * {@link IElement#animateAction(CustomAnimation, tripleplay.util.Interpolator, int)}
 * method.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface CustomAnimation {

    /**
     * <p>
     * This value will be change from 0.0f to 1.0f, depends on animation frame
     * </p>
     * <br/>
     * @param value
     */
    public abstract void update(float value);

}
