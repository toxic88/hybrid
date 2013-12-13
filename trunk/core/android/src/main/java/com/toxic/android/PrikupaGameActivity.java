package com.toxic.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.toxic.core.PrikupaGame;

public class PrikupaGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new PrikupaGame(new AndroidContext()));
  }
}
