package com.toxic.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.toxic.core.engine.BaseApp;
import com.toxic.core.engine.test.TestApplication;

public class BaseGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new BaseApp(new AndroidContext(), new TestApplication()));
  }
}
