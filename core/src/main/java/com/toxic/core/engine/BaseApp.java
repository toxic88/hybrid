package com.toxic.core.engine;

import playn.core.Game;
import playn.core.util.Clock;

import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;
import com.toxic.core.engine.util.Context;
import com.toxic.core.engine.util.log.LogLevel;
import com.toxic.core.engine.util.log.Logger;

/**
 * <p>
 * The inner object of logic engine.
 * </p>
 * <br/>
 * @author Strelock
 */
public final class BaseApp extends Game.Default {

    static Logger log;

    private static final int UPDATE_RATE = 30;
    private final Clock.Source clock = new Clock.Source(UPDATE_RATE);
    private final Context context;
    private final IApplication application;

    /**
     * <p>
     * Default application of game engine.
     * </p>
     * <br/>
     * @param platform instance of {@link IPlatform}
     */
    public BaseApp(IPlatform platform) {
        super(UPDATE_RATE);
        this.context = platform.getContext();
        this.application = platform.getApp();
        DataProvider.setApplication(this);
        DataProvider.getLogFactory().setLogLevel(LogLevel.WARN);
        DataProvider.getLogFactory().setPrintTime(true);
    }

    @Override
    public final void init() {
        log = DataProvider.getLogFactory().getLogger(BaseApp.class.getName());
        this.application.init();
    }

    @Override
    public final void update(int delta) {
        this.clock.update(delta);
        this.application.update(delta);
    }

    @Override
    public final void paint(float alpha) {
        this.clock.paint(alpha);
        TimerUtility.get().update();
        if (Scene.getCurrentScene() != null) {
            Scene.update(this.clock);
        }
    }

    /**
     * <p>
     * Context of application.
     * </p>
     * <br/>
     * @return instance of {@link Context}
     */
    final Context getContext() {
        return this.context;
    }

}
