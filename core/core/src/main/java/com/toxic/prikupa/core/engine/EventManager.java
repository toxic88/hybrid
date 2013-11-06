/**
 * 
 */
package com.toxic.prikupa.core.engine;

import static playn.core.PlayN.pointer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.toxic.prikupa.core.engine.util.Logger;
import com.toxic.prikupa.core.engine.util.LoggerFactory;

import playn.core.PlayN;
import playn.core.Pointer;
import playn.core.Pointer.Event;

/**
 * 
 * @author Strelock
 * 
 */
public class EventManager {
  
  final static Logger log = LoggerFactory.getLogger(EventManager.class.getSimpleName());

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

    private final List<BaseElement> parentsListOne = new LinkedList<BaseElement>();
    private final List<BaseElement> parentsListTwo = new LinkedList<BaseElement>();

    @Override
    public int compare(BaseElement o1, BaseElement o2) {

      if (o1 == null) {
        return 1;
      }

      if (o2 == null) {
        return 1;
      }

      if (o1.equals(o2)) {
        return 0;
      }

      getListOfParents(o1, this.parentsListOne);
      getListOfParents(o2, this.parentsListTwo);

      BaseElement parentFirst = this.parentsListOne.remove(this.parentsListOne.size() - 1), parentSecond = this.parentsListTwo
        .remove(this.parentsListTwo.size() - 1);

      if (parentFirst != parentSecond) {
        log.error("Current elements are not of the same Scene!");
        throw new IllegalStateException("Current elements are not of the same Scene!");
      }

      while (parentFirst == parentSecond && !this.parentsListOne.isEmpty() && !this.parentsListTwo.isEmpty()) {
        parentFirst = this.parentsListOne.remove(this.parentsListOne.size() - 1);
        parentSecond = this.parentsListTwo.remove(this.parentsListTwo.size() - 1);
      }

      if (this.parentsListOne.isEmpty()) {
        return 1;
      }

      if (this.parentsListTwo.isEmpty()) {
        return -1;
      }

      if (parentFirst.depth() < parentSecond.depth()) {
        return -1;
      }
      else if (parentFirst.depth() == parentSecond.depth()) {
        if (parentFirst.getParent().getRealDepth(parentFirst) > parentSecond.getParent().getRealDepth(parentSecond)) {
          return -1;
        }
        return 1;
      }
      else {
        return 1;
      }
    }

    private void getListOfParents(BaseElement o1, List<BaseElement> parentsList) {
      parentsList.clear();
      BaseElement temp = o1;
      parentsList.add(temp);
      while (!temp.isRoot()) {
        temp = temp.getParent();
        if (temp == null) {
          log.error("Comparing object doesn't have real root.");
          throw new IllegalStateException("Comparing object doesn't have real root.");
        }
        parentsList.add(temp);
      }
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
      EventManager.this.dispatchStartEvent(event);
    }

    @Override
    public void onPointerEnd(Event event) {
      event.flags().setPreventDefault(true);
      EventManager.this.dispatchSelect(event);
    }

    @Override
    public void onPointerDrag(Event event) {
      event.flags().setPreventDefault(true);
      dispatchMove(event);
    }

    @Override
    public void onPointerCancel(Event event) {
      event.flags().setPreventDefault(true);
      dispatchCancel(event);
      EventManager.this.targets.clear();
    }

  };

  void dispatchStartEvent(Event e) {
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

  void dispatchCancel(Event e) {
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

  void dispatchSelect(Event e) {
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

  void dispatchMove(Event e) {
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
