package com.toxic.core.engine.events;

/**
 * <p>
 * Represented based properties of event object.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface ActionEvent {

  /**
   * <p>
   * Returns location of event relative to X axis.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float getX();

  /**
   * <p>
   * Returns location of event relative to Y axis.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract float getY();

  /**
   * <p>
   * Return time of occurred event in milliseconds.
   * </p>
   * <br/>
   * 
   * @return
   */
  public abstract double getTime();
  
  /**
   * <p>
   * Weather current event is touchable.  
   * </p> 
   * <br/>
   * @return
   */
  public abstract boolean isTouch();

}
