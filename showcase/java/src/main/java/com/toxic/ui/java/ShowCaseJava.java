package com.toxic.ui.java;

import com.toxic.core.engine.base.IApplication;
import com.toxic.ui.core.ShowCase;
import com.toxic.java.PlatfromJava;

/**
 * <p>
 *  Test Java application.
 * </p>
 * <br/>
 * @author Strelock
 */
public class ShowCaseJava extends PlatfromJava {

    /**
     * <p>
     *  Default constructor of java platform.
     * </p> 
     * <br/>
     * @param app instance of application
     */
    public ShowCaseJava(IApplication app) {
        super(app);
    }

    public static void main(String[] args) {
        (new ShowCaseJava(new ShowCase())).start();
    }

}
