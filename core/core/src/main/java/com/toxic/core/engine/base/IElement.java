package com.toxic.core.engine.base;

import pythagoras.f.Point;
import tripleplay.util.Interpolator;

import com.toxic.core.engine.Backgound;
import com.toxic.core.engine.CustomAnimation;
import com.toxic.core.engine.EventManager;
import com.toxic.core.engine.TextFormat;
import com.toxic.core.engine.handlers.CancelHandler;
import com.toxic.core.engine.handlers.HoldHandler;
import com.toxic.core.engine.handlers.MoveHandler;
import com.toxic.core.engine.handlers.SelectHandler;

/**
 * <p>
 * This main object into the API. It provide generic element with wide
 * capabilities and functionality.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface IElement {

  /**
   * <p>
   * Setting up background as {@link Backgound} object.
   * </p>
   * <br/>
   * 
   * @param bkgroundIn
   */
  public abstract void setBackGround(Backgound bkgroundIn);

  /**
   * <p>
   * Bind this object with input {@link SelectHandler} object. It will be
   * executed, during object will be notified by {@link EventManager}.
   * </p>
   * <br/>
   * 
   * @param handly
   */
  public abstract void addSelectHandler(SelectHandler handly);

  /**
   * <p>
   * Bind this object with input {@link HoldHandler} object. It will be
   * executed, during object will be notified by {@link EventManager}.
   * </p>
   * <br/>
   * 
   * @param handly
   */
  public abstract void addHoldHandler(HoldHandler handly);

  /**
   * <p>
   * Bind this object with input {@link MoveHandler} object. It will be
   * executed, during object will be notified by {@link EventManager}.
   * </p>
   * <br/>
   * 
   * @param handly
   */
  public abstract void addMoveHandler(MoveHandler handly);

  /**
   * <p>
   * Remove all registered handler.
   * </p>
   * <br/>
   */
  public abstract void removeHandlers();

  /**
   * <p>
   * Removed binded {@link SelectHandler} object.
   * </p>
   * <br/>
   */
  public abstract void removeSelectHandler();

  /**
   * <p>
   * Removed binded {@link HoldHandler} object.
   * </p>
   * <br/>
   */
  public abstract void removeHoldHandler();

  /**
   * <p>
   * Removed binded {@link MoveHandler} object.
   * </p>
   * <br/>
   */
  public abstract void removeMoveHandler();

  /**
   * <p>
   * Determines weather current Element has at least one assign Handler
   * </p>
   * <br/>
   * 
   * @return true if Element has at least one handler
   */
  public abstract boolean hasHandlers();

  /**
   * <p>
   * Determines weather current Element has assigned {@link HoldHandler}
   * </p>
   * <br/>
   * 
   * @return true if Element has assigned {@link HoldHandler}
   */
  public abstract boolean hasHoldHandlers();

  /**
   * <p>
   * Determines weather current Element has assigned {@link SelectHandler}
   * </p>
   * <br/>
   * 
   * @return true if Element has assigned {@link SelectHandler}
   */
  public abstract boolean hasSelectHandlers();

  /**
   * <p>
   * Determines weather current Element has assigned {@link MoveHandler}
   * </p>
   * <br/>
   * 
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
   * 
   * @param child
   */
  public abstract void addChild(IElement child);

  /**
   * <p>
   * Remove input argument element from current element.
   * </p>
   * <br/>
   * 
   * @param child
   */
  public abstract void removeChild(IElement child);

  /**
   * <p>
   * Remove current element from it parent, if it exists.
   * </p>
   */
  public abstract void removeFromParent();

  /**
   * <p>
   * Bind to current element string identifier.
   * </p>
   * <br/>
   * 
   * @param string
   */
  public abstract void setId(String string);

  /**
   * <p>
   * Settled position of current element
   * </p>
   * <br/>
   * 
   * @param x
   *          location relative X axis
   * @param y
   *          location relative Y axis
   */
  public abstract void setPosition(float x, float y);

  /**
   * <p>
   * Set origin of current element. Relative point of origin current element
   * will be rotated and all child elements positioned.
   * </p>
   * <br/>
   * 
   * @param x
   *          location of X axis
   * @param y
   *          location of Y axis
   */
  public abstract void setOrigin(float x, float y);

  /**
   * <p>
   * Set rotating angle of element in radiant.
   * </p>
   * <br/>
   * 
   * @param angle
   *          radiant of rotating angle
   */
  public abstract void setRotation(float angle);

  /**
   * <p>
   * Setting visibility of element and all of it children.
   * </p>
   * <br/>
   * 
   * @param flag
   *          determine weather current instance visible
   */
  public abstract void setVisible(boolean flag);

  /**
   * <p>
   * Setting scaling of element.
   * </p>
   * <br/>
   * 
   * @param x
   *          scaling element relative axis X
   * @param y
   *          scaling element relative axis Y
   */
  public abstract void setScale(float x, float y);

  /**
   * <p>
   * Setting scaling of element.
   * </p>
   * <br/>
   * 
   * @param scale
   *          multiplier of scaling
   */
  public abstract void setScale(float scale);

  /**
   * <p>
   * Determine current position of element.
   * </p>
   * <br/>
   * 
   * @return {@link Point} object of position element.
   */
  public abstract Point position();

  /**
   * <p>
   * Determine current scaling multiplier of element.
   * </p>
   * <br/>
   * 
   * @return {@link Point} object of scaling multiplier.
   */
  public abstract Point scale();

  /**
   * <p>
   * Determine current depth of element
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float depth();

  /**
   * <p>
   * Determine weather element will be rendered.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract boolean isActive();

  /**
   * <p>
   * Absolute index of ordering {@link IElement}s according to depth.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract int getPriority();

  /**
   * <p>
   * If set input parameter as true, current element will have border of it
   * rendered region.
   * </p>
   * <br/>
   * 
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
   * 
   * @param alpha
   */
  public abstract void setAplha(float alpha);

  /**
   * <p>
   * Setting current width of element.
   * </p>
   * <br/>
   * 
   * @param width
   *          width of element
   */
  public abstract void setWidth(float width);

  /**
   * <p>
   * Setting current height of element.
   * </p>
   * <br/>
   * 
   * @param height
   *          height of element
   */
  public abstract void setHeight(float height);

  /**
   * <p>
   * Setting size of current element.
   * </p>
   * <br/>
   * 
   * @param x
   *          width of element
   * @param y
   *          height of element
   */
  public abstract void setSize(float x, float y);

  /**
   * <p>
   * Setting up depth of element. Depth determines ordering of element. If depth
   * of element greater then it sibling, it will be rendered early.
   * </p>
   * <br/>
   * 
   * @param depth
   */
  public abstract void setDepth(float depth);

  /**
   * <p>
   * Animate element randomly shifted it.
   * </p>
   * <br/>
   * 
   * @param amplitudeX
   *          maximum amplitude of shift relative X axis
   * @param amplitudeY
   *          maximum amplitude of shift relative Y axis
   * @param mode
   *          animation behavior
   * @param duration
   *          time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel
   *         animation.
   */
  public abstract CancelHandler animateShake(final float amplitudeX, final float amplitudeY, final Interpolator mode,
    final float duration);

  /**
   * <p>
   * Simple animation transition to supplied point.
   * </p>
   * <br/>
   * 
   * @param x
   *          location relative to axis X
   * @param y
   *          location relative to axis Y
   * @param mode
   *          the animation behavior mode
   * @param duration
   *          time in milliseconds
   * 
   * @return {@link CancelHandler} instance that ,has possibility cancel
   *         animation.
   */
  public abstract CancelHandler animateTransition(final float x, final float y, final Interpolator mode,
    final float duration);

  /**
   * <p>
   * Provide creation of complicated animation through the
   * {@link CustomAnimation} instance.
   * </p>
   * <br/>
   * 
   * @param action
   *          {@link CustomAnimation} object , that will be periodically
   *          executed through the {@link CustomAnimation#uppdate(float)}
   *          method.
   * @param mode
   *          the animation behavior mode
   * @param duration
   *          time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel
   *         animation.
   */
  public abstract CancelHandler animateAction(final CustomAnimation action, final Interpolator mode, final int duration);

  /**
   * <p>
   * Animate rotation of element to supplied value of angle in radiant.
   * </p>
   * <br/>
   * 
   * @param angle
   *          value of angle in radiant
   * @param mode
   *          the animation behavior mode
   * @param duration
   *          time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel
   *         animation.
   */
  public abstract CancelHandler animateRotate(final float angle, final Interpolator mode, final int duration);

  /**
   * <p>
   * Change alpha parameter from current to supplied subsequently time in
   * milliseconds.
   * </p>
   * <br/>
   * 
   * @param to
   *          value of alpha parameter in the end of animation.
   * @param mode
   *          the animation behavior mode
   * @param duration
   *          time in milliseconds
   * @return {@link CancelHandler} instance that ,has possibility cancel
   *         animation.
   */
  public abstract CancelHandler animateOpacity(final float to, final Interpolator mode, final int duration);

  /**
   * <p>
   * Stop all currently executed animation.
   * </p>
   * <br/>
   */
  public abstract void stopAnimation();

  /**
   * <p>
   * Stop current animated shake animation if it is executing now.
   * </p>
   * <br/>
   */
  public abstract void stopShakeAnimation();

  /**
   * <p>
   * Stop current animated transition animation if it is executing now.
   * </p>
   * <br/>
   */
  public abstract void stopTransitionAnimation();
  
  /**
   * <p>
   * Stop current animated custom animation if it is executing now.
   * </p> 
   * <br/>
   */
  public abstract void stopActionAnimation();

  /**
   * <p>
   * Stop current rotate transition animation if it is executing now.
   * </p>
   * <br/>
   */
  public abstract void stopRotateAnimation();

  /**
   * <p>
   * Stop current rotate opacity animation if it is executing now.
   * </p>
   * <br/>
   */
  public abstract void stopOpacityAnimation();

  /**
   * <p>
   * Determine weather current element is animating now.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract boolean isAnimated();

  /**
   * <p>
   * Determine weather current element is clipped.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract boolean isClipped();

  /**
   * <p>
   * Set current element be clipped, that will restrict drawing element and
   * background out of it boundaries.
   * </p>
   * <br/>
   * 
   * @param flag
   */
  public abstract void setClipped(boolean flag);

  /**
   * <p>
   * Set current element draw text in it according to {@link TextFormat} object.
   * </p>
   * <br/>
   * 
   * @param format
   */
  public abstract void setTextFromat(TextFormat format);

  /**
   * <p>
   * Width of element.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float width();

  /**
   * <p>
   * Height of element.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float height();

  /**
   * <p>
   * Opacity of element.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float alpha();

  /**
   * <p>
   * The x value of origin point of element. Relative origin point all children
   * element will be positioned.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float originX();

  /**
   * <p>
   * The y value of origin point of element. Relative origin point all children
   * element will be positioned.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float originY();

  /**
   * <p>
   * The x position of element. Relative position point element will be
   * positioned into parent.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float positionX();
  
  /**
   * <p>
   * Remove all children from this element. 
   * </p> 
   * <br/>
   */
  public abstract void removeChildren();
  
  /**
   * <p>
   * The y position of element. Relative position point element will be
   * positioned into parent.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float positionY();
  
  /**
   * @return The parent element of this element.
   */
  public abstract IElement getParent();
  
  /**
   * @return determine visibility of element.
   */
  public abstract boolean visible();
  
  /**
   * @return determine weather element will be propagate event to the underground elements.
   */
  public abstract boolean isPropagative();

  /**
   * <p>
   *  Set propagate event to underground elements. 
   * </p> 
   * <br/>
   * @param propogativeIn
   */
  public abstract void setPropagative(boolean propogativeIn);
  
  /**
   * @return weather this instance of {@link IElement} is Root - Scene
   *         element.
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