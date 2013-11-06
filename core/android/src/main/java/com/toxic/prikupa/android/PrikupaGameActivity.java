package com.toxic.prikupa.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.toxic.prikupa.core.PrikupaGame;

public class PrikupaGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new PrikupaGame());
  }
}
