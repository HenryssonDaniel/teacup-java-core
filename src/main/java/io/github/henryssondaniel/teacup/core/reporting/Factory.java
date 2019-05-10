package io.github.henryssondaniel.teacup.core.reporting;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory.
 *
 * @since 1.1
 */
public enum Factory {
  ;

  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());
  private static final Reporter REPORTER =
      new ReporterImpl(
          io.github.henryssondaniel.teacup.core.configuration.Factory.getProperties()
              .getProperty("reporter"));

  static {
    REPORTER.initialize();
  }

  /**
   * Returns the reporter.
   *
   * @return the reporter
   * @since 1.1
   */
  public static Reporter getReporter() {
    LOGGER.log(Level.FINE, "Returns the reporter.");
    return REPORTER;
  }
}
