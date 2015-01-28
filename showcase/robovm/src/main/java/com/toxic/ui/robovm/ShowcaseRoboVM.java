package com.toxic.ui.robovm;

import com.toxic.core.engine.base.IApplication;
import com.toxic.robovm.PlatformRoboVM;
import com.toxic.ui.core.ShowCase;


/**
 * <p>
 *  Launcher of roboVM platform's.
 * </p>
 * <br/>
 * @author Strelock
 *
 */
public class ShowcaseRoboVM extends PlatformRoboVM {

  /**
   * <p>
   *  Default constructor of java platform.
   * </p> 
   * <br/>
   * @param app instance of application
   */
  public ShowcaseRoboVM() {
    
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
    PlatformRoboVM.setApp(new ShowCase());
    (new ShowcaseRoboVM()).start();;
  }

}
