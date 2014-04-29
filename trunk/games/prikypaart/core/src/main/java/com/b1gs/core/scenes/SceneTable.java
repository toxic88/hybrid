package com.b1gs.core.scenes;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.IScene;

public class SceneTable {

    private final IScene scene;

    public SceneTable() {
        this.scene = DataProvider.createScene();
        // this.scene.setBackGround(new Backgound("images/table.jpg"));

    }

    public void activate() {
        this.scene.activate();
    }
}
