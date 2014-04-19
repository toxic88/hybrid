package com.b1gs.java;

import com.toxic.core.engine.base.IApplication;
import com.b1gs.core.Prikypa;
import com.toxic.java.PlatfromJava;

/**
 * <p>
 *  Test Java application.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class PrikypaJava extends PlatfromJava {

  /**
   * <p>
   *  Default constructor of java platform.
   * </p> 
   * <br/>
   * @param app instance of application
   */
  public PrikypaJava(IApplication app) {
    super(app);
  }

  public static void main(String[] args) {
    (new PrikypaJava(new Prikypa())).start();
  }

}
