package com.toxic.core.engine.util;

/**
 * <p>
 * Represent the global application context, for utility and useful object sharing.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface Context {

    /**
     * @return current representation of time in the pattern : HH:mm:sss
     */
    public abstract String getCurrentTime();

    /**
     * @param millsec amount of milliseconds till 1970s
     * @return formated representation of time in the pattern : HH:mm:sss
     */
    public abstract String convertMillseconds(double millsec);

}
