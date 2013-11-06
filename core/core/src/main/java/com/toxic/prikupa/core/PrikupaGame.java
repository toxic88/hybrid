package com.toxic.prikupa.core;

import playn.core.Font.Style;
import playn.core.Game;
import playn.core.PlayN;
import playn.core.Pointer.Event;
import playn.core.TextFormat.Alignment;
import playn.core.util.Clock;
import tripleplay.util.Interpolator;

import com.toxic.prikupa.core.engine.Backgound;
import com.toxic.prikupa.core.engine.BaseElement;
import com.toxic.prikupa.core.engine.CancelHandler;
import com.toxic.prikupa.core.engine.CustomAnimation;
import com.toxic.prikupa.core.engine.HoldHandler;
import com.toxic.prikupa.core.engine.MoveHandler;
import com.toxic.prikupa.core.engine.Scene;
import com.toxic.prikupa.core.engine.SelectHandler;
import com.toxic.prikupa.core.engine.TextFormat;
import com.toxic.prikupa.core.engine.util.LogLevel;
import com.toxic.prikupa.core.engine.util.Logger;
import com.toxic.prikupa.core.engine.util.LoggerFactory;
import com.toxic.prikupa.core.engine.util.TimerUtility;

public class PrikupaGame extends Game.Default {
  
  final static Logger log = LoggerFactory.getLogger(PrikupaGame.class.getSimpleName());

  
  //ANTS_TAG : should start refactored project, after providing Logger utility classes.
  private static final float WIDTH = 50;
  private static final float HEIGHT = 50;
  private static final int UPDATE_RATE = 30;
  private final Clock.Source clock = new Clock.Source(UPDATE_RATE);

  public PrikupaGame() {
    super(UPDATE_RATE);
    LoggerFactory.setLogLevel(LogLevel.WARN);
    LoggerFactory.setPrintTime(true);
  }

  @Override
  public void init() {
    log.debug("Start game!");
    final Scene main = new Scene();
    // ANTS_TAG : provide this feature to have possibility pause game,
    // during tabs for example switched PlayN.platform.setLifeCycle()
    main.setBackGround(new Backgound(0x0F00FF00));
    main.setId("main");
    // main.setDebug(true);
    main.setBackGround(new Backgound("images/towerdefense.png"));
    final BaseElement clipped = new BaseElement();
    clipped.setId("clipped");
    clipped.setClipped(true);
    clipped.setSize(400, 400);
    clipped.setOrigin(200, 200);
    clipped.setPosition(main.width() / 2f, main.height() / 2f);
    // clipped.setDebug(true);
    clipped.setBackGround(new Backgound(0x870000FF));

    main.addChild(clipped);
    clipped.setPropogative(false);
    // clipped.setDebug(true);
    TextFormat format = new TextFormat(PlayN.graphics().createFont("italic48", Style.ITALIC, 48), Alignment.CENTER);
    // format.setMargin(150f, 50f);
    clipped.setTextFromat(format);
    clipped.drawText("some value\ntest \nmore text!!!!!!");
    clipped.addSelectHandler(new SelectHandler() {
      private static final int MAX_RANGE = 700;

      @Override
      public void onSelect(Event e) {
        log.warn("clipped on select " + e.toString());
        BaseElement redQuad = new BaseElement();
        redQuad.setSize(WIDTH, HEIGHT);
        redQuad.setOrigin(WIDTH / 2f, HEIGHT / 2f);
        redQuad.setPosition(e.localX() - main.width() / 2f + 200, e.localY() - main.height() / 2f + 200);
        redQuad.setRotation((float) (Math.PI * 2f * PlayN.random()));
        redQuad.setBackGround(new Backgound(0xFFFF0000));
        clipped.addChild(redQuad);
        redQuad.animateTransition(e.localX() + (PlayN.random() * MAX_RANGE - MAX_RANGE / 2),
          e.localY() + (PlayN.random() * MAX_RANGE - MAX_RANGE / 2), Interpolator.EASE_INOUT, 1500);
        redQuad.animateRotate((float) (Math.PI * 2.f), Interpolator.EASE_OUT_BACK, 1500);
        redQuad.animateOpacity(0.2f, Interpolator.LINEAR, 700);
      }

    });
    main.addMoveHandler(new MoveHandler() {

      @Override
      public void onMove(Event e) {
        log.warn("main : on drug " + e.toString());
      }

    });
    main.addSelectHandler(new SelectHandler() {

      @Override
      public void onSelect(Event e) {
        log.warn("main on select " + e.toString());
        final BaseElement elem = new BaseElement();
        elem.setSize(WIDTH, HEIGHT);
        elem.setPropogative(false);
        elem.setId("Tween-Shake element!");
        // ANTS_TAG : investigate rotation of clipped elements!
        // elem.setClipped(true);
        elem.setOrigin(0f, 0f);
        elem.setBackGround(new Backgound(0xFF00FFFF));
        elem.setPosition(e.localX(), e.localY());
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
          public void onHold(Event eventHold) {
            PlayN.log().warn("on hold event : " + eventHold.toString());
            if (this.cancel != null) {
              PlayN.log().warn("Previous shake event doesn't properly ended" + "\nWill forced it.");
              this.cancel.stop();
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
    this.clock.update(delta);
  }

  @Override
  public void paint(float alpha) {
    // ANTS_TAG : think up better encapsulation!
    this.clock.paint(alpha);
    TimerUtility.getInstance().update();
    if (Scene.getCurrentScene() != null) {
      Scene.update(this.clock);
    }
  }
}
