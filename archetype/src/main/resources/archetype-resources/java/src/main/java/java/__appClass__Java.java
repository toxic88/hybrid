#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.java;

import com.toxic.core.engine.base.IApplication;
import ${package}.core.${appClass};
import com.toxic.java.PlatfromJava;

/**
 * <p>
 *  Test Java application.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class ${appClass}Java extends PlatfromJava {

  /**
   * <p>
   *  Default constructor of java platform.
   * </p> 
   * <br/>
   * @param app instance of application
   */
  public ${appClass}Java(IApplication app) {
    super(app);
  }

  public static void main(String[] args) {
    (new ${appClass}Java(new ${appClass}())).start();
  }

}
