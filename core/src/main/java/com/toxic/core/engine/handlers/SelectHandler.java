package com.toxic.core.engine.handlers;

import com.toxic.core.engine.events.ActionEvent;

/**
 * <p>
 * You should link this handler with certain {@link BaseElement}. Current
 * handler will be executed, when binded element excited.
 * </p>
 * <br/>
 * @author Strelock
 */
public interface SelectHandler {

	/**
	 * Will be executed when selected element.
	 */
	public abstract void onSelect(ActionEvent e);

}
