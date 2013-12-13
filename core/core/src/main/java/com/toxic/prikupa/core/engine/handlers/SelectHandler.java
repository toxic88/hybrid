/**
 * 
 */
package com.toxic.prikupa.core.engine.handlers;

import com.toxic.prikupa.core.engine.events.ActionEvent;

/**
 * <p>
 * You should link this handler with certain {@link BaseElement}. Current
 * handler will be executed, when binded element excited.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface SelectHandler {

	/**
	 * <p>
	 * Will be executed when selected element.
	 * </p>
	 */
	public abstract void onSelect(ActionEvent e);

}
