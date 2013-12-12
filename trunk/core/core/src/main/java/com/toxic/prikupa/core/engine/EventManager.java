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

  private final Set<CachedPriority> used = new HashSet<CachedPriority>();

  final Queue<CachedPriority> targets = new PriorityQueue<CachedPriority>(12, new Comparator<CachedPriority>() {

    @Override
    public int compare(CachedPriority o1, CachedPriority o2) {

      if (o1.getPriority() > o2.getPriority()) {
        return -1;
      }

      if (o1.getPriority() < o2.getPriority()) {
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
      event.flags().setPropagationStopped(false);
      EventManager.this.targets.clear();
      EventManager.this.dispatchStartEvent(new ActionEventImpl(event));
    }

    @Override
    public void onPointerEnd(Event event) {
      event.flags().setPreventDefault(true);
      event.flags().setPropagationStopped(false);
      EventManager.this.dispatchSelect(new ActionEventImpl(event));
      EventManager.this.targets.clear();
    }

    @Override
    public void onPointerDrag(Event event) {
      event.flags().setPreventDefault(true);
      event.flags().setPropagationStopped(false);
      dispatchMove(new ActionEventImpl(event));
    }

    @Override
    public void onPointerCancel(Event event) {
      event.flags().setPreventDefault(true);
      event.flags().setPropagationStopped(false);
      dispatchCancel(new ActionEventImpl(event));
      EventManager.this.targets.clear();
    }

  };

  void dispatchStartEvent(ActionEvent e) {
    for (BaseElement elem : this.registared) {
      if (elem.hitTest(e)) {
        this.targets.add(new CachedPriority(elem));
      }
    }
    this.used.clear();
    for (CachedPriority elem : this.targets) {
      elem.getElement().dispatchEventStart(e);
      this.used.add(elem);
      if (!elem.getElement().isPropogative()) {
        break;
      }
    }
    this.targets.retainAll(this.used);
  }

  void dispatchCancel(ActionEvent e) {
    for (CachedPriority elem : this.targets) {
      elem.getElement().dispatchCancelEvent(e);
      if (!elem.getElement().isPropogative()) {
        break;
      }
    }
    this.targets.clear();
  }

  void dispatchSelect(ActionEvent e) {
    for (CachedPriority elem : this.targets) {
      if (elem.getElement().hitTest(e)) {
        elem.getElement().dispatchSelectEvent(e);
        if (!elem.getElement().isPropogative()) {
          break;
        }
      }
    }
    this.targets.clear();
  }

  void dispatchMove(ActionEvent e) {
    // ANTS_TAG : should think up about out of boundary case!
    this.used.clear();
    for (CachedPriority elem : this.targets) {
      if (elem.getElement().hitTest(e)) {
        elem.getElement().dispatchMoveEvent(e);
        if (!elem.getElement().isPropogative()) {
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

  /**
   * <p>
   * Goal of this class cached priority for discrete time.
   * </p>
   * <br/>
   * 
   * @author Strelock
   * 
   */
  private static class CachedPriority {

    private final BaseElement element;
    private final int priority;

    /**
     * <p>
     * Cached constructor.
     * </p>
     * <br/>
     * 
     * @param elem
     */
    CachedPriority(BaseElement elem) {
      this.element = elem;
      this.priority = elem.getPriority();
    }

    /**
     * @return unwrapped instance of {@link BaseElement}
     */
    BaseElement getElement() {
      return this.element;
    }

    /**
     * @return pre-computed value of priority
     */
    int getPriority() {
      return this.priority;
    }
    
    @Override
    public String toString(){
      return this.element.toString() + ", priority : " + this.priority;
    }

  }

}
