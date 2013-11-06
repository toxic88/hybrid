/**
 * 
 */
package com.toxic.prikupa.core.engine.util;

import tripleplay.util.Timer;

/**
 * @author Strelock
 * 
 */
public class TimerUtility extends Timer {

  private static final TimerUtility timer = new TimerUtility();

  public static TimerUtility getInstance() {
    return timer;
  }

  @Override
  public Handle every(int millis, Runnable action) {
    return super.every(millis, action);
  }

  @Override
  public Handle after(int millis, Runnable action) {
    return super.after(millis, action);
  }

  @Override
  public Handle atThenEvery(int initialMillis, int repeatMillis, Runnable action) {
    return super.atThenEvery(initialMillis, repeatMillis, action);
  }

  @Override
  public void update() {
    super.update();
    // int size = sizeOfActiveTask(timer._root);
    // if(size!=0){
    // PlayN.log().debug("Active tasks : is " + size);
    // }
  }

  // private static int sizeOfActiveTask(Action action_root) {
  // int counter=1;
  // while(action_root.next!=null){
  // counter++;
  // }
  // return counter;
  // }

}
