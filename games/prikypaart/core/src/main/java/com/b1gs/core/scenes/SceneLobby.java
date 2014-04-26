package com.b1gs.core.scenes;

import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.Backgound;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.resources.ITextFormat;

public class SceneLobby {

    private final IScene scene;

    public SceneLobby() {
        this.scene = DataProvider.createScene();
        this.scene.setBackGround(new Backgound(0xFF006F00));
        init();
    }

    public void init() {
        final ITextFormat tableFormat = DataProvider.createTextFormat(DataProvider.createFont("TableFont", Style.ITALIC, 15), Alignment.LEFT, 0xFF0F0F0F);

        final IElement lobbySection = DataProvider.createElement();
        lobbySection.setSize(800, 500);
        lobbySection.setPosition(20, 10);
        lobbySection.setBackGround(new Backgound(0x5F000000));

        final IElement tableLabel = DataProvider.createElement();
        tableLabel.setSize(800, 50);
        tableLabel.setBackGround(new Backgound(0xFF00A0A0));
        tableLabel.drawText("Tables :");
        tableLabel.setTextFromat(tableFormat);

        lobbySection.addChild(tableLabel);

        this.scene.addChild(lobbySection);

    }

    public void activate() {
        this.scene.activate();
    }

    private void initLobby() {

    }

    private void initInfo() {
        final ITextFormat playerInfoFormat = DataProvider.createTextFormat(DataProvider.createFont("PlayerInfoFont", Style.ITALIC, 10),
                                                                           Alignment.LEFT,
                                                                           0xFF0F0F0F);

        final IElement infoSection = DataProvider.createElement();
        infoSection.setSize(300, 500);
        infoSection.setPosition(870, 10);
        infoSection.setBackGround(new Backgound(0x5F000000));

        // infoSection.setTextFromat(playerInfoFormat);
        // infoSection.drawText("Players info: ");

        final IElement infoSectionLabel = DataProvider.createElement();
        infoSectionLabel.setSize(300, 50);
        // infoSectionLabel.setPosition(20, 20);
        infoSectionLabel.setBackGround(new Backgound(0xEFFF0000));
        infoSectionLabel.setTextFromat(playerInfoFormat);
        infoSectionLabel.drawText("Playersinfo: ");

        infoSection.addChild(infoSectionLabel);

        this.scene.addChild(infoSection);
    }
}
