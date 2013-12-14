package com.toxic.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.toxic.core.engine.BaseGame;
import com.toxic.core.engine.base.IApplication;

public class BaseGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new BaseGame(new AndroidContext(), new IApplication() {

      @Override
      public void update(int delta) {
        // NOOP
      }

      @Override
      public void init() {
        // NOOP
      }
    }));
  }
}
