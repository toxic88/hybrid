package com.b1gs.core.scenes;

import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.Background;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

public class SceneLogin {

    private final IScene scene;

    public SceneLogin() {
        this.scene = DataProvider.createScene();
        init();
    }

    public void init() {
        this.scene.setId("main");
        this.scene.setBackGround(new Background("images/bg.jpg"));

        final IElement loginWindow = DataProvider.createElement();
        loginWindow.setId("loginWnd");
        loginWindow.setSize(420, 222);
        loginWindow.setBackGround(new Background("images/login_window.jpg"));
        loginWindow.setPosition((this.scene.width() - loginWindow.width()) / 2, (this.scene.height() - loginWindow.height()) / 2);

        ITextFormat format = DataProvider.createTextFormat(DataProvider.createFont("italic48", Style.BOLD_ITALIC, 14), Alignment.CENTER, 0xFF000000);

        final IElement loginBttn = DataProvider.createElement();
        loginBttn.setId("loginBttn");
        loginBttn.setSize(115, 40);
        loginBttn.setPosition(577, 418);
        loginBttn.drawText("Login");
        loginBttn.setTextFormat(format);

        loginBttn.addSelectHandler(new SelectHandler() {

            @Override
            public void onSelect(ActionEvent e) {
                System.out.println("You have been loged in!");
            }
        });

        this.scene.addChild(loginWindow);
        this.scene.addChild(loginBttn);
    }

    public void activate() {
        this.scene.activate();
    }
}
