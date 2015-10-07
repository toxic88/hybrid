package com.toxic.robovm;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIInterfaceOrientationMask;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;

import playn.robovm.RoboPlatform;

import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;
import com.toxic.core.engine.util.Context;

/**
 * <p>
 *  Concrete implementation for roboVM's platform.
 * </p>
 * <br/>
 * @author Strelock
 */
public class PlatformRoboVM extends UIApplicationDelegateAdapter implements IPlatform {

    protected static String[] ARGS;
    private static final Context CONTEXT = new RoboVMContext();
    protected static IApplication APPLICATION;

    /**
     * Necessary for roboVM implementation - think about better approach!
     */
    public PlatformRoboVM() {

    }

    public static void setApp(IApplication app) {
        APPLICATION = app;
    }

    @Override
    public final IApplication getApp() {
        return APPLICATION;
    }

    @Override
    public final Context getContext() {
        return CONTEXT;
    }

    /**
     * Start game launching.
     */
    public final void start() {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(getArgs(), null, PlatformRoboVM.class);
        pool.close();
    }

    @Override
    public final boolean didFinishLaunching(UIApplication app, UIApplicationLaunchOptions launchOpts) {
        // create a full-screen window
        CGRect bounds = UIScreen.getMainScreen().getBounds();
        UIWindow window = new UIWindow(bounds);

        // configure and register the PlayN platform; start our game
        RoboPlatform.Config config = new RoboPlatform.Config();
        config.orients = UIInterfaceOrientationMask.All;
        RoboPlatform pf = RoboPlatform.register(window, config);
        pf.run(new BaseApp(this));

        // make our main window visible
        window.makeKeyAndVisible();
        addStrongRef(window);
        return true;
    }

    public static final String[] getArgs() {
        return ARGS;
    }

    public static final void setArgs(String[] args) {
        ARGS = args;
    }

}
