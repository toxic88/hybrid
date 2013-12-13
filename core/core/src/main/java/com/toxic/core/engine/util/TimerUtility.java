/**
 * 
 */
package com.toxic.core.engine.util;

import java.util.HashMap;
import java.util.Map;

import tripleplay.util.Timer;

import com.toxic.core.engine.handlers.CancelHandler;

/**
 * <p>
 * Implementation of wrapper {@link Timer}.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public class TimerUtility implements AppTimer {

  private static final Logger log = LoggerFactory.getLogger(TimerUtility.class.getName());

  private static final TimerUtility instance = new TimerUtility();

  public static AppTimer getInstance() {
    return instance;
  }

  private final Timer timer = new Timer();

  final Map<Runnable, CancelHandler> cancels = new HashMap<Runnable, CancelHandler>();

  /**
   * <p>
   * Default hidden constructor, for singleton ensuring.
   * </p>
   * <br/>
   */
  private TimerUtility() {
  }

  @Override
  public CancelHandler every(int millis, Runnable action) {
    CancelHandler handler = new CancelAction(this.timer.every(millis, new ActionWrapper(action)));
    this.cancels.put(action, handler);
    return handler;
  }

  @Override
  public CancelHandler after(int millis, Runnable action) {
    CancelHandler handler = new CancelAction(this.timer.after(millis, new ActionWrapper(action)));
    this.cancels.put(action, handler);
    return handler;
  }

  @Override
  public CancelHandler atThenEvery(int initialMillis, int repeatMillis, Runnable action) {
    CancelHandler handler = new CancelAction(this.timer.atThenEvery(initialMillis, repeatMillis, new ActionWrapper(
      action)));
    this.cancels.put(action, handler);
    return handler;
  }

  void removeCancelHandler(CancelHandler handle) {
    this.cancels.remove(handle);
  }

  @Override
  public void update() {
    this.timer.update();
    int size = this.cancels.size();
    if (size != 0) {
      log.debug("Active tasks : is " + size);
    }
  }

  /**
   * <p>
   * Removed handlers from collection, after proper execution.
   * </p>
   * <br/>
   * 
   * @author Strelock
   * 
   */
  private class ActionWrapper implements Runnable {

    private final Runnable action;

    /**
     * <p>
     * Simple wrapper of actions for proper disposing {@link CancelHandler}s
     * binded with executed actions.
     * </p>
     * <br/>
     * 
     * @param act
     */
    ActionWrapper(Runnable act) {
      this.action = act;
    }

    @Override
    public void run() {
      this.action.run();
      TimerUtility.this.cancels.remove(this.action);
    }

  }

}
