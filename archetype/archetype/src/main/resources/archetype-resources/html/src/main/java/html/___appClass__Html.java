#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.html;

import ${package}.core.${appClass};
import com.toxic.html.ApplicationHtml;


/**
 * <p>
 *  Entry point of 'html' module.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class ${appClass}Html extends ApplicationHtml {

  @Override
  public void setApplication() {
    this.application = new ${appClass}();
  }


}
