/**
 * 
 */
package com.toxic.prikupa.core.engine.handlers;

import com.toxic.prikupa.core.engine.EventManager;

import playn.core.Pointer.Event;

/**
 * @author Strelock
 * 
 */
public interface HoldHandler {

    /**
     * <p>
     * If event starting on specified element, and doesn't change it location
     * {@link EventManager#TIME_TO_NOTIFY_HOLD} milliseconds and newer move
     * event location layouts around {@link EventManager#RADIUS_HIT}, in contrast
     * to initial event, {@link HoldHandler} will be subsequently periodically called.
     * </p>
     * <br/>
     * 
     * @param e
     */
    public abstract void onHold(Event e);

}
