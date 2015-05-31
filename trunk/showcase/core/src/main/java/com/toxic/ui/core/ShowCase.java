package com.toxic.ui.core;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.base.Background;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.MoveHandler;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.util.log.LogLevel;
import com.toxic.core.engine.util.log.Logger;

/**
 * <p>
 * The application logic example.
 * </p>
 * <br/>
 * @author Strelock
 */
public class ShowCase implements IApplication {

    /**
     * Default constructor.
     */
    public ShowCase() {
        // NOOP
    }

    @Override
    public void init() {
        DataProvider.getLogFactory().setLogLevel(LogLevel.DEBUG);
        final Logger log = DataProvider.getLogFactory().getLogger(MoveHandler.class.getSimpleName());
        final IScene main = DataProvider.createScene();
        // Strelock : provide this feature to have possibility pause game,
        // during tabs for example switched PlayN.platform.setLifeCycle()
        main.setBackGround(new Background(0x0F00FF00));
        main.setId("main");
        main.setBackGround(new Background("images/towerdefense.png"));
        main.activate();
        main.addSelectHandler(new SelectHandler() {

            @Override
            public void onSelect(ActionEvent e) {
                // temporary!
                //            PlayN.assets().getRemoteImage("http://myitforum.com/myitforumwp/wp-content/uploads/2014/12/evil-eye.jpg").addCallback( new Callback<Image>() {
                //
                //                @Override
                //                public void onSuccess(Image result) {
                //                    log.warn("onSuccess");
                //                }
                //
                //                @Override
                //                public void onFailure(Throwable cause) {
                //                    log.error("onFailure",cause);
                //                }
                //                
                //            });;
            }
        });
        final IElement moveElem = DataProvider.createElement();
        moveElem.setSize(100f, 100f);
        moveElem.setBackGround(new Background(0xFF00FF00));
        moveElem.setOrigin(50f, 50f);
        moveElem.setPosition(main.width() / 2f, main.height() / 2f);
        main.addChild(moveElem);
        moveElem.addMoveHandler(new MoveHandler() {

            private float previousX = Float.MAX_VALUE;
            private float previousY = Float.MAX_VALUE;
            private float deltaX = 0;
            private float deltaY = 0;

            @Override
            public void onMove(ActionEvent e) {
                log.warn("start");
                if (this.previousX == Float.MAX_VALUE) {
                    log.warn("create previous");
                    this.previousX = e.getX();
                    this.previousY = e.getY();
                    return;
                }
                this.deltaX = e.getX() - this.previousX;
                this.deltaY = e.getY() - this.previousY;
                this.previousX = e.getX();
                this.previousY = e.getY();
                moveElem.setPosition(moveElem.positionX() + this.deltaX, moveElem.positionY() + this.deltaY);
                log.warn("moved element to : [" + this.deltaX + "x" + this.deltaY + "].");
            }
        });
    }

    @Override
    public void update(int delta) {
        // empty block
    }

}
