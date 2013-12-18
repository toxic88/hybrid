package com.toxic.java;

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
public class DemoApplicationJava extends PlatfromJava {

  /**
   * <p>
   *  Default constructor of java platform.
   * </p> 
   * <br/>
   * @param app instance of application
   */
  public DemoApplicationJava(IApplication app) {
    super(app);
  }

  public static void main(String[] args) {
    (new DemoApplicationJava(new DemoApplication())).start();
  }

}
