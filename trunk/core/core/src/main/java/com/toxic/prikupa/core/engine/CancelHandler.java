/**
 * 
 */
package com.toxic.prikupa.core.engine;

/**
 * <p>Use specially to stop certain animation.</p>
 * <br/>
 * @author Strelock
 *
 */
public interface CancelHandler {
    
    /**
     * <p>
     * Stop binded animation, that bound to this handler.
     * </p>
     * <br/>
     */
    public abstract void stop();

}
