package com.b1gs.core;

import com.b1gs.core.scenes.SceneLobby;
import com.toxic.core.engine.base.IApplication;

/**
 * <p>
 * The application logic example.
 * </p>
 * <br/>
 * 
 * @author Strelock
 */
public class Prikypa
    implements IApplication {

    private static final float WIDTH = 50;
    private static final float HEIGHT = 50;

    /**
     * <p>
     * Default constructor.
     * </p>
     * <br/>
     */
    public Prikypa() {
        // NOOP
    }

    @Override
    public void init() {

        // ANTS_TAG : provide this feature to have possibility pause game,
        // during tabs for example switched PlayN.platform.setLifeCycle()

        // final IScene second = DataProvider.createScene();
        // second.setBackGround(new Backgound(0xFF00FF00));
        // second.setId("sec");

        // new SceneLogin().activate();
        new SceneLobby().activate();
    }

    @Override
    public void update(int delta) {
        // empty block
    }

}
