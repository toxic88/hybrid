#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.android;

import com.toxic.android.PlatfromAndroid;
import ${package}.core.${appClass};


/**
 * <p>Example of executing android application.</p>
 * <br/>
 * @author Strelock
 *
 */
public class ${appClass}Android extends PlatfromAndroid {

  @Override
  public void setApplication() {
    this.application = new ${appClass}();
  }

}
