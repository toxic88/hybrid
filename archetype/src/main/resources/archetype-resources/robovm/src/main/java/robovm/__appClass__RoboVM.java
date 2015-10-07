#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.robovm;

import com.toxic.robovm.PlatformRoboVM;
import ${package}.core.${appClass};


/**
 * <p>
 *  Launcher of roboVM platform's.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class ${appClass}RoboVM extends PlatformRoboVM {
    
    /**
     * <p>
     *  Default constructor of java platform.
     * </p> 
     * <br/>
     * @param app instance of application
     */
    public ${appClass}RoboVM() {
      
    }

    /**
     * <p>
     *  Entry point for roboVM project.
     * </p>
     * <br/>
     *  Strelock : add link here!
     * <br/>
     * @param args
     */
    public static void main(String[] args) {
      PlatformRoboVM.setArgs(args);
      PlatformRoboVM.setApp(new ${appClass}());
      (new ${appClass}RoboVM()).start();;
    }

}
