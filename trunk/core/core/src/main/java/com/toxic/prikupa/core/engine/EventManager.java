/**
 * 
 */
package com.toxic.prikupa.core.engine;

import static playn.core.PlayN.pointer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import playn.core.PlayN;
import playn.core.Pointer;
import playn.core.Pointer.Event;

import com.toxic.prikupa.core.engine.events.ActionEvent;
import com.toxic.prikupa.core.engine.handlers.HoldHandler;
import com.toxic.prikupa.core.engine.util.Logger;
import com.toxic.prikupa.core.engine.util.LoggerFactory;

/**
 * 
 * @author Strelock
 * 
 */
public class EventManager {
  
  final static Logger log = LoggerFactory.getLogger(EventManager.class.getName());

  // ANTS_TAG : should also organize additional event for handle policy of out
  // of bounce
  // ANTS_TAG : of moving or holding elements
  // ANTS_TAG : improve policy of draggable element. If user doesn't move
  // element
  // ANTS_TAG : think up about case, when start event on upper layer, but
  // subsequently moved to more higher layer...
  // ANTS_TAG : what should be in this case?

  /**
   * <p>
   * Time before will be called {@link HoldHandler} instance, that exist on
   * active {@link BaseElement} .
   * </p>
   * <br/>
   */
  public static int TIME_TO_NOTIFY_HOLD = 600;

  /**
   * <p>
   * Radius, that allows simulate similar, but not same event coordinates onMove
   * element.
   * </p>
   * <br/>
   */
  public static float RADIUS_HIT = 15.0f;

  private volatile static EventManager instanse = new EventManager();

  public static EventManager getInstanse() {
    return instanse;
  }

  private final Set<BaseElement> registared = new HashSet<BaseElement>();

  final Queue<BaseElement> targets = new PriorityQueue<BaseElement>(12, new Comparator<BaseElement>() {

    @Override
    public int compare(BaseElement o1, BaseElement o2) {

      if (o1 == null) {
        return 1;
      }

      if (o2 == null) {
        return 1;
      }
      
      if(o1.getPriority()>o2.getPriority()){
        return -1;
      }
      
      if(o1.getPriority()<o2.getPriority()){
        return 1;
      }

      return 0;
    }

  });

  private EventManager() {
    PlayN.platform().setPropagateEvents(false);
    PlayN.platform().mouse().setListener(null);
    PlayN.platform().mouse().setEnabled(false);
    PlayN.platform().touch().setListener(null);
    PlayN.platform().touch().setEnabled(false);
    pointer().setEnabled(true);
    pointer().setListener(this.listener);
  }

  // ANTS_TAG : remove pointer create : touch and mouse separately
  // ANTS_TAG : for better times :)
  private final Pointer.Listener listener = new Pointer.Listener() {

    @Override
    public void onPointerStart(Event event) {
      event.flags().setPreventDefault(true);
      EventManager.this.dispatchStartEvent(new ActionEventImpl(event));
    }

    @Override
    public void onPointerEnd(Event event) {
      event.flags().setPreventDefault(true);
      EventManager.this.dispatchSelect(new ActionEventImpl(event));
    }

    @Override
    public void onPointerDrag(Event event) {
      event.flags().setPreventDefault(true);
      dispatchMove(new ActionEventImpl(event));
    }

    @Override
    public void onPointerCancel(Event event) {
      event.flags().setPreventDefault(true);
      dispatchCancel(new ActionEventImpl(event));
      EventManager.this.targets.clear();
    }

  };

  void dispatchStartEvent(ActionEvent e) {
    for (BaseElement elem : this.registared) {
      if (elem.hitTest(e)) {
        this.targets.add(elem);
      }
    }
    for (BaseElement elem : this.targets) {
      elem.dispatchEventStart(e);
      if (!elem.isPropogative()) {
        break;
      }
    }
  }

  void dispatchCancel(ActionEvent e) {
    for (BaseElement elem : this.targets) {
      if (elem.hitTest(e)) {
        elem.dispatchCancelEvent(e);
        if (!elem.isPropogative()) {
          break;
        }
      }
    }
    this.targets.clear();
  }

  void dispatchSelect(ActionEvent e) {
    for (BaseElement elem : this.targets) {
      if (elem.hitTest(e)) {
        elem.dispatchSelectEvent(e);
        if (!elem.isPropogative()) {
          break;
        }
      }
    }
    this.targets.clear();
  }

  void dispatchMove(ActionEvent e) {
    // ANTS_TAG : should think up about out of boundary case!
    for (BaseElement elem : this.targets) {
      if (elem.hitTest(e)) {
        elem.dispatchMoveEvent(e);
        if (!elem.isPropogative()) {
          break;
        }
      }
    }
  }

  public void registareTarget(BaseElement elem) {
    this.registared.add(elem);
  }

  public void unregistareTarget(BaseElement elem) {
    this.registared.remove(elem);
  }

}
