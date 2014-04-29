package com.b1gs.core.scenes;

import playn.core.Font.Style;
import playn.core.TextFormat.Alignment;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.Backgound;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

public class SceneLobby {

    private final IScene scene;
    private IElement joinBttn;
    private boolean isActive = false;

    public SceneLobby() {
        this.scene = DataProvider.createScene();
        this.scene.setBackGround(new Backgound(0xFF006F00));
        init();
    }

    public void init() {

        initInfo();
        initLobby();

    }

    public void activate() {
        this.scene.activate();
    }

    private void initLobby() {
        final ITextFormat tableFormat = DataProvider.createTextFormat(DataProvider.createFont("TableFont", Style.BOLD_ITALIC, 20), Alignment.LEFT, 0xFF0F0F0F);

        // Lobby section background
        final IElement lobbySection = DataProvider.createElement();
        lobbySection.setId("LobbySection");
        lobbySection.setSize(800, 500);
        lobbySection.setPosition(20, 10);
        lobbySection.setBackGround(new Backgound(0x5F000000));

        // Label for lobby
        final IElement lobbyLabel = DataProvider.createElement();
        lobbyLabel.setId("LobbyLabel");
        lobbyLabel.setSize(800, 50);
        lobbyLabel.setBackGround(new Backgound(0xFF00A0A0));
        lobbyLabel.drawText("Tables :");
        lobbyLabel.setTextFromat(tableFormat);

        // Join button background
        this.joinBttn = DataProvider.createElement();
        this.joinBttn.setId("LobbyJoinBttn");
        this.joinBttn.setSize(100, 50);
        this.joinBttn.setPosition(700, 500);
        this.joinBttn.setBackGround(new Backgound(0xFF8F8F8F));
        this.joinBttn.setAplha(0.5f);

        final ITextFormat joinBttnFormat = DataProvider.createTextFormat(DataProvider.createFont("TableFont", Style.BOLD, 20), Alignment.CENTER, 0xFF0F0F0F);
        // Join button
        final IElement joinBttnLabel = DataProvider.createElement();
        joinBttnLabel.setId("LobbyJoinBttn");
        joinBttnLabel.setSize(100, 50);
        joinBttnLabel.drawText("Join");
        joinBttnLabel.setTextFromat(joinBttnFormat);
        joinBttnLabel.addSelectHandler(new SelectHandler() {

            @Override
            public void onSelect(ActionEvent e) {
                if (SceneLobby.this.isActive) {
                    new SceneTable().activate();
                }
            }

        });

        this.joinBttn.addChild(joinBttnLabel);

        // Lobby's table list element
        final IElement el = createTableElement(0, 50);

        lobbySection.addChild(lobbyLabel);
        lobbySection.addChild(el);
        lobbySection.addChild(this.joinBttn);
        this.scene.addChild(lobbySection);
    }

    private IElement createTableElement(float posX, float posY) {

        final ITextFormat tableElemFormat = DataProvider.createTextFormat(DataProvider.createFont("TableFont", Style.BOLD_ITALIC, 15),
                                                                          Alignment.CENTER,
                                                                          0xFF5F5F5F);

        final IElement tableElem = DataProvider.createElement();
        tableElem.setSize(800, 50);
        tableElem.setPosition(posX, posY);
        tableElem.setBackGround(new Backgound(0x3F000000));

        // Table element in tablelist
        final IElement tableElemLabel = DataProvider.createElement();
        tableElemLabel.setSize(800, 50);
        tableElemLabel.drawText("Prikypa first game table!");
        tableElemLabel.setTextFromat(tableElemFormat);
        tableElemLabel.addSelectHandler(new SelectHandler() {

            @Override
            public void onSelect(ActionEvent e) {
                System.out.println("You are were logged in to table!");
                SceneLobby.this.joinBttn.setAplha(1);
                SceneLobby.this.isActive = true;
                // tableElem;
            }

        });

        tableElem.addChild(tableElemLabel);
        return tableElem;
    }

    private void initInfo() {
        final ITextFormat playerInfoFormat = DataProvider.createTextFormat(DataProvider.createFont("PlayerInfoFont", Style.BOLD, 15),
                                                                           Alignment.LEFT,
                                                                           0xFF0F0F0F);

        final IElement infoSection = DataProvider.createElement();
        infoSection.setSize(300, 500);
        infoSection.setPosition(870, 10);
        infoSection.setBackGround(new Backgound(0x5F000000));

        final IElement infoSectionLabel = DataProvider.createElement();
        infoSectionLabel.setSize(300, 50);
        // infoSectionLabel.setPosition(20, 20);
        infoSectionLabel.setBackGround(new Backgound(0xEFFF0000));
        infoSectionLabel.setTextFromat(playerInfoFormat);
        infoSectionLabel.drawText("Players Info: ");

        infoSection.addChild(infoSectionLabel);

        this.scene.addChild(infoSection);
    }
}
