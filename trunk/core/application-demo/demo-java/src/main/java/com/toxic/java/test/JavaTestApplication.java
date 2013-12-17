package com.toxic.java.test;

import com.toxic.core.engine.base.IApplication;
import com.toxic.core.engine.test.DemoApplication;
import com.toxic.java.PlatfromJava;

/**
 * <p>
 *  Test Java application.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class JavaTestApplication extends PlatfromJava {

  /**
   * <p>
   *  Default constructor of java platform.
   * </p> 
   * <br/>
   * @param app instance of application
   */
  public JavaTestApplication(IApplication app) {
    super(app);
  }

  public static void main(String[] args) {
    (new JavaTestApplication(new DemoApplication())).start();
  }

}
