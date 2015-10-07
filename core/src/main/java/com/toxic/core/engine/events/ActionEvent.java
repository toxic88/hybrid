package com.toxic.core.engine.events;

/**
 * <p>
 * Represented based properties of event object.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface ActionEvent {

  /**
   * @return location of event relative to X axis.
   */
  public abstract float getX();

  /**
   * @return location of event relative to Y axis.
   */
  public abstract float getY();

  /**
   * @return time of occurred event in milliseconds.
   */
  public abstract double getTime();
  
  /**
   * @return weather current event is touchable.
   */
  public abstract boolean isTouch();

}
