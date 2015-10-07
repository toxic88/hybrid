package com.toxic.core.engine.base;

import java.util.List;

import playn.core.TextFormat;
import pythagoras.f.Point;
import tripleplay.util.Interpolator;

import com.toxic.core.engine.EventManager;
import com.toxic.core.engine.animation.CustomAnimation;
import com.toxic.core.engine.handlers.CancelHandler;
import com.toxic.core.engine.handlers.HoldHandler;
import com.toxic.core.engine.handlers.MoveHandler;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

/**
 * <p>
 * This main object into the API. It provide generic element with wide
 * capabilities and functionality.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface IElement {

  /**
   * <p>
   * Setting up background as {@link Background} object.
   * </p>
   * <br/>
   * @param bkgroundIn
   */
  public abstract void setBackGround(Background bkgroundIn);

  /**
   * <p>
   * Bind this object with input {@link SelectHandler} object. It will be
   * executed, during object will be notified by {@link EventManager}.
   * </p>
   * <br/>
   * @param handly
   */
  public abstract void addSelectHandler(SelectHandler handly);

  /**
   * <p>
   * Bind this object with input {@link HoldHandler} object. It will be
   * executed, during object will be notified by {@link EventManager}.
   * </p>
   * <br/>
   * @param handly
   */
  public abstract void addHoldHandler(HoldHandler handly);

  /**
   * <p>
   * Bind this object with input {@link MoveHandler} object. It will be
   * executed, during object will be notified by {@link EventManager}.
   * </p>
   * <br/>
   * @param handly
   */
  public abstract void addMoveHandler(MoveHandler handly);

  /**
   * Remove all registered handler.
   */
  public abstract void removeHandlers();

  /**
   * Removed binded {@link SelectHandler} object.
   */
  public abstract void removeSelectHandler();

  /**
   * Removed binded {@link HoldHandler} object.
   */
  public abstract void removeHoldHandler();

  /**
   * Removed binded {@link MoveHandler} object.
   */
  public abstract void removeMoveHandler();

  /**
   * <p>
   * Determines weather current Element has at least one assign Handler
   * </p>
   * <br/>
   * @return true if Element has at least one handler
   */
  public abstract boolean hasHandlers();

  /**
   * <p>
   * Determines weather current Element has assigned {@link HoldHandler}
   * </p>
   * <br/>
   * @return true if Element has assigned {@link HoldHandler}
   */
  public abstract boolean hasHoldHandlers();

  /**
   * <p>
   * Determines weather current Element has assigned {@link SelectHandler}
   * </p>
   * <br/>
   * @return true if Element has assigned {@link SelectHandler}
   */
  public abstract boolean hasSelectHandlers();

  /**
   * <p>
   * Determines weather current Element has assigned {@link MoveHandler}
   * </p>
   * <br/>
   * @return true if Element has assigned {@link MoveHandler}
   */
  public abstract boolean hasMoveHandlers();

  /**
   * <p>
   * Add child to current element. Child will be positioned relative to current
   * element.
   * </p>
   * <p>
   * <b>NOTE : if current element {@link IElement#isClipped()} rendering out of
   * it size elements will be skipped.</b>
   * </p>
   * <br/>
   * @param child
   */
  public abstract void addChild(IElement child);

  /**
   * <p>
   * Add child to current element. Child will be positioned relative to current
   * element.
   * </p>
   * <p>
   * <b>NOTE : if current element {@link IElement#isClipped()} rendering out of
   * it size elements will be skipped.</b>
   * </p>
   * <br/>
   * @param children
   */
  public abstract void addChildren(List<IElement> children);

  /**
   * <p>
   * Remove input argument element from current element.
   * </p>
   * <br/>
   * @param child
   */
  public abstract void removeChild(IElement child);

  /**
   * Remove current element from it parent, if it exists.
   */
  public abstract void removeFromParent();

  /**
   * <p>
   * Bind to current element string identifier.
   * </p>
   * <br/>
   * @param string
   */
  public abstract void setId(String string);

  /**
   * Return a current element string identifier.
   */
  public abstract String getId();

  /**
   * <p>
   * Settled position of current element
   * </p>
   * <br/>
   * @param x location relative X axis
   * @param y location relative Y axis
   */
  public abstract void setPosition(float x, float y);

  /**
   * <p>
   * Settled X axis position of current element
   * </p>
   * <br/>
   * @param x location relative X axis
   */
  public abstract void setPositionX(float x);

  /**
   * <p>
   * Settled Y axis position of current element
   * </p>
   * <br/>
   * @param Y location relative Y axis
   */
  public abstract void setPositionY(float y);

  /**
   * <p>
   * Set origin of current element. Relative point of origin current element
   * will be rotated and all child elements positioned.
   * </p>
   * <br/>
   * @param x location of X axis
   * @param y location of Y axis
   */
  public abstract void setOrigin(float x, float y);

  /**
   * <p>
   * Set origin of current element. Relative point of origin current element
   * will be rotated and all child elements positioned.
   * </p>
   * <br/>
   * @param x location of X axis
   */
  public abstract void setOriginX(float x);

  /**
   * <p>
   * Set origin of current element. Relative point of origin current element
   * will be rotated and all child elements positioned.
   * </p>
   * <br/>
   * @param y location of Y axis
   */
  public abstract void setOriginY(float y);

  /**
   * <p>
   * Set rotating angle of element in radiant.
   * </p>
   * <br/>
   * @param angle radiant of rotating angle
   */
  public abstract void setRotation(float angle);

  /**
   * <p>
   * Setting visibility of element and all of it children.
   * </p>
   * <br/>
   * @param flag determine weather current instance visible
   */
  public abstract void setVisible(boolean flag);

  /**
   * <p>
   * Setting scaling of element.
   * </p>
   * <br/>
   * @param x scaling element relative axis X
   * @param y scaling element relative axis Y
   */
  public abstract void setScale(float x, float y);

  /**
   * <p>
   * Setting scaling of element.
   * </p>
   * <br/>
   * @param scale multiplier of scaling
   */
  public abstract void setScale(float scale);

  /**
   * <p>
   * Determine current position of element.
   * </p>
   * <br/>
   * @return {@link Point} object of position element.
   */
  public abstract Point position();

  /**
   * <p>
   * Determine current scaling multiplier of element.
   * </p>
   * <br/>
   * @return {@link Point} object of scaling multiplier.
   */
  public abstract Point scale();

  /**
   * @return current scaling multiplier of element relative to axis X.
   */
  public abstract float scaleX();

  /**
   * @return current scaling multiplier of element relative to axis Y.
   */
  public abstract float scaleY();

  /**
   * @return current depth of element
   */
  public abstract float depth();

  /**
   * @return current depth of element
   */
  public abstract boolean isActive();

  /**
   * @return Absolute index of ordering {@link IElement}s according to depth.
   */
  public abstract int getPriority();

  /**
   * <p>
   * If set input parameter as true, current element will have border of it
   * rendered region.
   * </p>
   * <br/>
   * @param flag
   */
  public abstract void setDebug(boolean flag);

  /**
   * <p>
   * Setting up opacity value of element.
   * </p>
   * <p>
   * <b> NOTE : opacity coudn't be less or equals zero or greater then one. </b>
   * </p>
   * <br/>
   * @param alpha
   */
  public abstract void setAplha(float alpha);

  /**
   * <p>
   * Setting current width of element.
   * </p>
   * <br/>
   * @param width width of element
   */
  public abstract void setWidth(float width);

  /**
   * <p>
   * Setting current height of element.
   * </p>
   * <br/>
   * @param height height of element
   */
  public abstract void setHeight(float height);

  /**
   * <p>
   * Setting size of current element.
   * </p>
   * <br/>
   * @param x width of element
   * @param y height of element
   */
  public abstract void setSize(float x, float y);

  /**
   * <p>
   * Setting up depth of element. Depth determines ordering of element. If depth
   * of element greater then it sibling, it will be rendered early.
   * </p>
   * <br/>
   * @param depth
   */
  public abstract void setDepth(float depth);

  /**
   * <p>
   * Animate element randomly shifted it.
   * </p>
   * <br/>
   * @param amplitudeX maximum amplitude of shift relative X axis
   * @param amplitudeY maximum amplitude of shift relative Y axis
   * @param mode animation behavior
   * @param duration time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel animation.
   */
  public abstract CancelHandler animateShake(final float amplitudeX, final float amplitudeY, final Interpolator mode,
    final float duration);

  /**
   * <p>
   * Simple animation transition to supplied point.
   * </p>
   * <br/>
   * @param x location relative to axis X
   * @param y location relative to axis Y
   * @param mode the animation behavior mode
   * @param duration time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel animation.
   */
  public abstract CancelHandler animateTransition(final float x, final float y, final Interpolator mode,
    final float duration);

  /**
   * <p>
   * Provide creation of complicated animation through the
   * {@link CustomAnimation} instance.
   * </p>
   * <br/>
   * @param action {@link CustomAnimation} object , that will be periodically executed through 
   * the {@link CustomAnimation#update(float)} method.
   * @param mode the animation behavior mode
   * @param duration time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel animation.
   */
  public abstract CancelHandler animateAction(final CustomAnimation action, final Interpolator mode, final int duration);

  /**
   * <p>
   * Animate rotation of element to supplied value of angle in radiant.
   * </p>
   * <br/>
   * @param angle value of angle in radiant
   * @param mode the animation behavior mode
   * @param duration time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel animation.
   */
  public abstract CancelHandler animateRotate(final float angle, final Interpolator mode, final int duration);

  /**
   * <p>
   * Change alpha parameter from current to supplied subsequently time in
   * milliseconds.
   * </p>
   * <br/>
   * @param to value of alpha parameter in the end of animation.
   * @param mode the animation behavior mode
   * @param duration time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel animation.
   */
  public abstract CancelHandler animateOpacity(final float to, final Interpolator mode, final int duration);

  /**
   * Stop all currently executed animation.
   */
  public abstract void stopAnimation();

  /**
   * Stop current animated shake animation if it is executing now.
   */
  public abstract void stopShakeAnimation();

  /**
   * Stop current animated transition animation if it is executing now.
   */
  public abstract void stopTransitionAnimation();

  /**
   * Stop current animated custom animation if it is executing now.
   */
  public abstract void stopActionAnimation();

  /**
   * Stop current rotate transition animation if it is executing now.
   */
  public abstract void stopRotateAnimation();

  /**
   * Stop current rotate opacity animation if it is executing now.
   */
  public abstract void stopOpacityAnimation();

  /**
   * @return whether current element is animating now.
   */
  public abstract boolean isAnimated();

  /**
   * @return whether current element is clipped.
   */
  public abstract boolean isClipped();

  /**
   * <p>
   * Set current element be clipped, that will restrict drawing element and
   * background out of it boundaries.
   * </p>
   * <br/>
   * @param flag
   */
  public abstract void setClipped(boolean flag);

  /**
   * <p>
   * Set current element draw text in it according to {@link TextFormat} object.
   * </p>
   * <br/>
   * @param format
   */
  public abstract void setTextFormat(ITextFormat format);

  /**
   * @return width of element.
   */
  public abstract float width();

  /**
   * @return height of element.
   */
  public abstract float height();

  /**
   * @return opacity of element.
   */
  public abstract float alpha();

  /**
   * @return value of origin point of element. Relative origin point all children element will be positioned.
   */
  public abstract float originX();

  /**
   * @return value of origin point of element. Relative origin point all children element will be positioned.
   */
  public abstract float originY();

  /**
   * @return the x position of element. Relative position point element will be positioned into parent.
   */
  public abstract float positionX();

  /**
   * Remove all children from this element.
   */
  public abstract void removeChildren();

  /**
   * @return y position of element. Relative position point element will be positioned into parent.
   */
  public abstract float positionY();

  /**
   * @return The parent element of this element.
   */
  public abstract IElement getParent();

  /**
   * @return determine visibility of element.
   */
  public abstract boolean isVisible();

  /**
   * @return determine weather element will be propagate event to the underground elements.
   */
  public abstract boolean isPropagative();

  /**
   * <p>
   * Set propagate event to underground elements.
   * </p>
   * <br/>
   * @param propogativeIn
   */
  public abstract void setPropagative(boolean propogativeIn);

  /**
   * @return weather this instance of {@link IElement} is Root - Scene element.
   */
  public abstract boolean isRoot();

  /**
   * <p>
   * Draws input text into element.
   * </p>
   * <br/>
   * @param value
   */
  public abstract void drawText(String value);

}
