package com.toxic.core.engine;

import playn.core.Pointer.Event;

import com.toxic.core.PrikupaGame;
import com.toxic.core.engine.events.ActionEvent;

/**
 * <p>
 * Implementation of event API {@link ActionEvent}.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
class ActionEventImpl implements ActionEvent {
  
  private final float x;
  private final float y;
  private final double time;
  private final boolean isTouch;
  
  /**
   * <p>
   * Default implementation of {@link ActionEvent} 
   * </p> 
   * <br/>
   * @param event native dispatched event.
   */
  ActionEventImpl(Event event) {
    this.x=event.x();
    this.y = event.y();
    this.time = event.time();
    this.isTouch = event.isTouch();
  }

  @Override
  public float getX() {
    return this.x;
  }

  @Override
  public float getY() {
    return this.y;
  }

  @Override
  public double getTime() {
    return this.time;
  }

  @Override
  public boolean isTouch() {
    return this.isTouch;
  }
  
  @Override
  public String toString(){
    return "The event element occureted at : ["+this.x+":"+this.y+"] time : " + PrikupaGame.getContext().convertMillseconds(this.time) + " .";
  }

}
