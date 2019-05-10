package io.github.henryssondaniel.teacup.core.configuration;

import java.nio.file.Path;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration factory.
 *
 * @since 1.1
 */
public enum Factory {
  ;

  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());
  private static final Properties PROPERTIES =
      new ConfigureImpl()
          .loadProperties(
              Path.of(System.getProperty("user.home"))
                  .resolve(".teacup")
                  .resolve("teacup.properties")
                  .toFile());

  /**
   * Returns the properties.
   *
   * @return the properties
   * @since 1.1
   */
  public static Properties getProperties() {
    LOGGER.log(Level.FINE, "Returns the properties.");
    return new Properties(PROPERTIES);
  }
}
