package io.github.henryssondaniel.teacup.core.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConfigureImpl implements Configure {
  private static final Logger LOGGER = Logger.getLogger(ConfigureImpl.class.getName());

  @Override
  public Properties loadProperties(File file) {
    var properties = new Properties();

    if (file.exists())
      try (InputStream inputStream = new FileInputStream(file)) {
        properties.load(inputStream);
      } catch (IOException e) {
        LOGGER.log(Level.WARNING, "The properties could not be loaded.", e);
      }

    return properties;
  }
}
