package com.toxic.ui.core;

import playn.core.Font.Style;
import playn.core.PlayN;
import playn.core.TextFormat.Alignment;
import tripleplay.util.Interpolator;

import com.toxic.core.engine.DataProvider;
import com.toxic.core.engine.animation.CustomAnimation;
import com.toxic.core.engine.base.Backgound;
import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.base.IElement;
import com.toxic.core.engine.base.IScene;
import com.toxic.core.engine.events.ActionEvent;
import com.toxic.core.engine.handlers.CancelHandler;
import com.toxic.core.engine.handlers.HoldHandler;
import com.toxic.core.engine.handlers.MoveHandler;
import com.toxic.core.engine.handlers.SelectHandler;
import com.toxic.core.engine.resources.ITextFormat;

/**
 * <p>
 * The application logic example.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public class ShowCase implements IApplication {

  private static final float WIDTH = 50;
  private static final float HEIGHT = 50;

  /**
   * <p>
   * Default constructor.
   * </p>
   * <br/>
   */
  public ShowCase() {
    // NOOP
  }

  @Override
  public void init() {
    final IScene main = DataProvider.createScene();
    // ANTS_TAG : provide this feature to have possibility pause game,
    // during tabs for example switched PlayN.platform.setLifeCycle()
    main.setBackGround(new Backgound(0x0F00FF00));
    main.setId("main");
    // main.setDebug(true);
    main.setBackGround(new Backgound("images/towerdefense.png"));
    final IElement clipped = DataProvider.createElement();
    clipped.setId("clipped");
    clipped.setClipped(true);
    clipped.setSize(400, 400);
    clipped.setOrigin(200, 200);
    clipped.setPosition(main.width() / 2f, main.height() / 2f);
    // clipped.setDebug(true);
    clipped.setBackGround(new Backgound(0x870000FF));

    main.addChild(clipped);
    clipped.setPropagative(false);
    // clipped.setDebug(true);
    ITextFormat format = DataProvider.createTextFormat(DataProvider.createFont("italic48", Style.ITALIC, 48),
      Alignment.CENTER);
    // format.setMargin(150f, 50f);
    clipped.setTextFromat(format);
    clipped.drawText("some value\ntest \nmore text!!!!!!");
    clipped.addSelectHandler(new SelectHandler() {
      private static final int MAX_RANGE = 700;

      @Override
      public void onSelect(ActionEvent e) {
        IElement redQuad = DataProvider.createElement();
        redQuad.setSize(WIDTH, HEIGHT);
        redQuad.setOrigin(WIDTH / 2f, HEIGHT / 2f);
        redQuad.setPosition(e.getX() - main.width() / 2f + 200, e.getY() - main.height() / 2f + 200);
        redQuad.setRotation((float) (Math.PI * 2f * PlayN.random()));
        redQuad.setBackGround(new Backgound(0xFFFF0000));
        clipped.addChild(redQuad);
        redQuad.animateTransition(e.getX() + (PlayN.random() * MAX_RANGE - MAX_RANGE / 2), e.getY()
          + (PlayN.random() * MAX_RANGE - MAX_RANGE / 2), Interpolator.EASE_INOUT, 1500);
        redQuad.animateRotate((float) (Math.PI * 2.f), Interpolator.EASE_OUT_BACK, 1500);
        redQuad.animateOpacity(0.2f, Interpolator.LINEAR, 700);
      }

    });
    main.addMoveHandler(new MoveHandler() {

      @Override
      public void onMove(ActionEvent e) {
        // NOOP
      }

    });
    main.addSelectHandler(new SelectHandler() {

      @Override
      public void onSelect(ActionEvent e) {
        final IElement elem = DataProvider.createElement();
        elem.setSize(WIDTH, HEIGHT);
        elem.setPropagative(false);
        elem.setId("Tween-Shake element!");
        // ANTS_TAG : investigate rotation of clipped elements!
        // elem.setClipped(true);
        elem.setOrigin(0f, 0f);
        elem.setBackGround(new Backgound(0xFF00FFFF));
        elem.setPosition(e.getX(), e.getY());
        main.addChild(elem);
        elem.animateAction(new CustomAnimation() {

          private static final float RADIUS = 100;

          @Override
          public void uppdate(float value) {
            float radians = (float) (Math.PI * 10.0f * value);
            float distanceXOrigin = (float) (Math.sqrt(value) * RADIUS);
            float distanceYOrigin = (float) (Math.sqrt(value) * RADIUS);
            elem.setRotation(radians);
            elem.setOrigin(distanceXOrigin, -distanceYOrigin);
            elem.setScale(1.0f + value);
            if (value == 1.0f) {
              elem.setPosition(elem.positionX() - distanceXOrigin, elem.positionY() + distanceYOrigin);
              elem.setOrigin(0, 0);
            }
          }
        }, Interpolator.EASE_OUT_BACK, 5000);
        elem.addHoldHandler(new HoldHandler() {

          private CancelHandler cancel;

          @Override
          public void onHold(ActionEvent eventHold) {
            if (this.cancel != null) {
              this.cancel.cancel();
            }
            this.cancel = elem.animateShake(3.0f, 3.0f, Interpolator.EASE_IN_BACK, 100);
          }
        });
      }

    });
    main.activate();
  }

  @Override
  public void update(int delta) {
    // empty block
  }

}
