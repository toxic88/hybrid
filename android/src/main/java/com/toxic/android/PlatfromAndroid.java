package com.toxic.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IPlatform;
import com.toxic.core.engine.util.Context;

/**
 * <p>
 *  Android implementation of {@link IPlatform} interface.
 * </p>
 * <br/>
 * @author Strelock
 */
public abstract class PlatfromAndroid extends GameActivity implements IPlatform {

    private final Context context = new AndroidContext();

    protected IApplication application;

    /**
     * Default constructor. 
     */
    public PlatfromAndroid() {
        setApplication();
    }

    /**
     *  For proper launching should define {@link PlatfromAndroid#application} variable.
     */
    public abstract void setApplication();

    @Override
    public final IApplication getApp() {
        return this.application;
    }

    @Override
    public final Context getContext() {
        return this.context;
    }

    @Override
    public final void main() {
        PlayN.run(new BaseApp(this));
    }

}
