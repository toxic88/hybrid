package com.toxic.core.engine;

import java.util.HashSet;
import java.util.Set;

import com.toxic.core.engine.base.IScene;

import playn.core.PlayN;
import playn.core.util.Clock;

/**
 * <p>
 * The basic class of activity. It allows update whole scene inner logic and
 * switch between them.
 * </p>
 * <br/>
 * @author Strelock
 */
final class Scene extends BaseElement implements IScene {

    private static Set<Scene> STACK = new HashSet<>();
    private static Scene CURRENT;

    public static Scene getCurrentScene() {
        return CURRENT;
    }

    /**
     * Default constructor
     */
    public Scene() {
        STACK.add(this);
        setSize(PlayN.graphics().width(), PlayN.graphics().height());
    }

    @Override
    public void activate() {
        if (CURRENT != null) {
            PlayN.graphics().rootLayer().remove(CURRENT.layer);
            CURRENT.disableElements();
            CURRENT.unLoad();
        }
        PlayN.graphics().rootLayer().add(this.layer);
        initScene();
        enableElements();
        CURRENT = this;
    }

    @Override
    public boolean isRoot() {
        return true;
    }

    /**
     * Create cached instances of child elements.  
     */
    private void initScene() {
        //Strelock : add here callbacks
        preload();
    }

    /**
     * Release unused resource objects. 
     */
    private void unLoad() {
        //Strelock : add here callbacks!
        releaseResources();
    }

    /**
     * Update CURRENT inner consistency.
     */
    public final static void update(Clock clock) {
        anim.paint(clock);
    }

}
