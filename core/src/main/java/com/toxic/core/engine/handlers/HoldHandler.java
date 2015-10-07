package com.toxic.core.engine.handlers;

import com.toxic.core.engine.EventManager;
import com.toxic.core.engine.events.ActionEvent;

/**
 * <p>
 * Executing after user pressed certain object, after expired
 * {@link EventManager#TIME_TO_NOTIFY_HOLD} milliseconds and subsequently every
 * {@link EventManager#TIME_EVERY_HOLD} milliseconds.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface HoldHandler {

    /**
     * <p>
     * If event starting on specified element, and doesn't change it location
     * {@link EventManager#TIME_TO_NOTIFY_HOLD} milliseconds and newer move event
     * location layouts around {@link EventManager#RADIUS_HIT}, in contrast to
     * initial event, {@link HoldHandler} will be subsequently periodically
     * called.
     * </p>
     * <br/>
     * @param e
     */
    public abstract void onHold(ActionEvent e);

}
