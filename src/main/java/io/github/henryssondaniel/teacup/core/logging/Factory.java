package io.github.henryssondaniel.teacup.core.logging;

import java.util.logging.Logger;

/**
 * Factory.
 *
 * @since 1.1
 */
public enum Factory {
  ;

  /**
   * Returns the logger.
   *
   * @param clazz the class
   * @return the logger
   * @since 1.1
   */
  public static Logger getLogger(Class<?> clazz) {
    var logger = Logger.getLogger(clazz.getName());

    if (logger.getHandlers().length == 0) logger.addHandler(new ReporterHandlerImpl());

    return logger;
  }
}
