package com.toxic.core.engine;

import static playn.core.PlayN.pointer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import playn.core.PlayN;
import playn.core.Pointer;
import playn.core.Pointer.Event;

import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.HoldHandler;
import com.toxic.core.engine.util.log.Logger;

/**
 * <p>
 * Response for proper manegmnent of events in proper order.
 * </p>
 * <br/>
 * @author Strelock
 */
public final class EventManager implements IEventManager {

    final static Logger log = DataProvider.getLogFactory().getLogger(EventManager.class.getName());

    // Strelock : should also organize additional event for handle policy of out of bounce
    // Strelock : of moving or holding elements
    // Strelock : improve policy of draggable element. If user doesn't move element
    // Strelock : think up about case, when start event on upper layer, but
    // subsequently moved to more higher layer...
    // Strelock : what should be in this case?
    // Strelock : provide possibility of custom event handling.

    /**
     * Time before will be called {@link HoldHandler} instance, that exist on
     * active {@link IElement} .
     */
    public static int TIME_TO_NOTIFY_HOLD = 600;

    /**
     * Time of stopping before next periodically executing {@link HoldHandler}
     * instance, that exist on active {@link IElement} .
     */
    public static int TIME_EVERY_HOLD = 1000;

    /**
     * Radius, that allows simulate similar, but not same event coordinates onMove
     * element.
     */
    public static float RADIUS_HIT = 3.0f;

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

    /**
     * <p>
     * Provide possibility for enable or disable Pointer interaction
     * </p>
     * <br/>
     * @param flag
     */
    public void enableInteraction(boolean flag) {
        pointer().setEnabled(flag);
    }

    // Strelock : remove pointer create : touch and mouse separately
    // Strelock : for better times :)
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
            if (!elem.getElement().isPropagative()) {
                break;
            }
        }
        this.targets.retainAll(this.used);
    }

    void dispatchCancel(ActionEvent e) {
        for (CachedPriority elem : this.targets) {
            elem.getElement().dispatchCancelEvent(e);
            if (!elem.getElement().isPropagative()) {
                break;
            }
        }
        this.targets.clear();
    }

    void dispatchSelect(ActionEvent e) {
        for (CachedPriority elem : this.targets) {
            if (elem.getElement().hitTest(e)) {
                elem.getElement().dispatchSelectEvent(e);
                if (!elem.getElement().isPropagative()) {
                    break;
                }
            }
        }
        this.targets.clear();
    }

    void dispatchMove(ActionEvent e) {
        // Strelock : should think up about out of boundary case!
        this.used.clear();
        for (CachedPriority elem : this.targets) {
            if (elem.getElement().hitTest(e)) {
                elem.getElement().dispatchMoveEvent(e);
                if (!elem.getElement().isPropagative()) {
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
     * @author Strelock
     */
    private static class CachedPriority {

        private final BaseElement element;
        private final int priority;

        /**
         * <p>
         * Cached constructor.
         * </p>
         * <br/>
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
        public String toString() {
            return this.element.toString() + ", priority : " + this.priority;
        }

    }

}
