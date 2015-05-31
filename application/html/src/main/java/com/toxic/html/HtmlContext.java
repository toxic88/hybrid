package com.toxic.html;

import java.util.Date;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.toxic.core.engine.util.Context;

/**
 * <p>
 *  Html's implementation of {@link Context}. 
 * </p>
 * <br/>
 * @author Strelock
 */
final class HtmlContext implements Context {

    @Override
    public String getCurrentTime() {
        return DateTimeFormat.getFormat("HH:mm:ss:SSS").format(new Date());
    }

    @Override
    public String convertMillseconds(double millsec) {
        return DateTimeFormat.getFormat("HH:mm:ss:SSS").format(new Date((long) millsec));
    }

}
