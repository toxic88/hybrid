package com.toxic.core.engine.util;

import com.toxic.core.engine.handlers.CancelHandler;

/**
 * <p>
 *  Basic API of timer into application.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface AppTimer {

    /**
     * <p>
     * Repeatedly execute action after expired milliseconds time.
     * </p>
     * <br/>
     * @param millis
     * @param action
     * @return instance of {@link CancelHandler} with possibility {@link CancelHandler#cancel()}
     */
    public abstract CancelHandler every(int millis, Runnable action);

    /**
     * <p>
     * Execute action after expired milliseconds time.
     * </p>
     * <br/>
     * @param millis
     * @param action
     * @return instance of {@link CancelHandler} with possibility {@link CancelHandler#cancel()}
     */
    public abstract CancelHandler after(int millis, Runnable action);

    /**
     * <p>
     * Execute action after expired fir milliseconds time's parameter and
     * subsequently repeatedly execute task every repeatMillis milliseconds.
     * </p>
     * <br/>
     * @param initialMillis
     * @param repeatMillis
     * @param action
     * @return instance of {@link CancelHandler} with possibility {@link CancelHandler#cancel()}
     */
    public abstract CancelHandler atThenEvery(int initialMillis, int repeatMillis, Runnable action);

}
