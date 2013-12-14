package com.toxic.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.toxic.core.engine.BaseGame;

public class BaseGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new BaseGame(new AndroidContext()));
  }
}
