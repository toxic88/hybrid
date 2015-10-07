package com.toxic.core.engine;

import java.util.HashMap;
import java.util.Map;

import tripleplay.util.Timer;

import com.toxic.core.engine.handlers.CancelHandler;
import com.toxic.core.engine.util.AppTimer;
import com.toxic.core.engine.util.log.Logger;

/**
 * <p>
 *  Implementation of wrapper {@link Timer}.
 * </p>
 * <br/>
 * @author Strelock
 */
final class TimerUtility implements AppTimer {

  private static final Logger log = DataProvider.getLogFactory().getLogger(TimerUtility.class.getName());

  private static final TimerUtility instance = new TimerUtility();

  /**
   * @return instance of {@link AppTimer}
   */
  public static AppTimer getInstance() {
    return instance;
  }
  
  /**
   * @return hidden method provided package visibility.
   */
  static TimerUtility get() {
    return instance;
  }

  private final Timer timer = new Timer();

  final Map<Runnable, CancelHandler> cancels = new HashMap<Runnable, CancelHandler>();

  /**
   * Default hidden constructor, for singleton ensuring.
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

  /**
   * Check weather necessary execute any pending task.
   */
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
   * @author Strelock
   */
  private class ActionWrapper implements Runnable {

    private final Runnable action;

    /**
     * <p>
     * Simple wrapper of actions for proper disposing {@link CancelHandler}s
     * binded with executed actions.
     * </p>
     * <br/>
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
