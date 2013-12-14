package com.toxic.core.engine.util.log;


/**
 * <p>
 *  Interface provided possibility create {@link Logger} instance for specified
 * class. Also provided capabilities of management log level and customize output template.
 * </p>
 * <br/>
 * 
 * @author Strelock
 * 
 */
public interface LogFactory {
  
  /**
   * <p>
   * Setting global logic level, to prevent print less of settled level
   * messages.
   * </p>
   * <br/>
   * 
   * @param logLevel
   */
  public abstract void setLogLevel(LogLevel logLevel);
  
  /**
   * <p>
   * Determines weather logging process should also contains time of printing
   * message.
   * </p>
   * <br/>
   * <b>By default : false .</b> <br/>
   * 
   * @param flag
   */
  public abstract void setPrintTime(boolean flag);
  
  /**
   * <p>
   * Return logger for corresponding className
   * </p> 
   * <br/>
   * @param className
   * @return
   */
  public abstract Logger getLogger(String className);

}
