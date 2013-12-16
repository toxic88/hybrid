package com.toxic.java.test;

import com.toxic.core.engine.test.TestApplication;
import com.toxic.java.BaseApplicationJava;

/**
 * @author Strelock
 *
 */
public class JavaTestApplication {

  public static void main(String[] args) {
    BaseApplicationJava.getInstance().start(new TestApplication());
  }

}
