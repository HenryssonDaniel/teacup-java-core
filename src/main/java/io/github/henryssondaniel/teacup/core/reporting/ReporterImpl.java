package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Container;
import io.github.henryssondaniel.teacup.core.testing.Executable;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Root;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class ReporterImpl implements Reporter {
  private static final Logger LOGGER = Logger.getLogger(ReporterImpl.class.getName());
  private final Collection<Reporter> reporters = new LinkedList<>();

  ReporterImpl(File file) {
    if (file.exists()) {
      var property = loadProperties(file).getProperty("reporter");

      if (property != null && !property.isEmpty())
        for (var name : property.split(",")) addReporter(name);
    }
  }

  @Override
  public void finished(Result result) {
    LOGGER.log(Level.FINE, "Finished with result");
    reporters.forEach(reporter -> reporter.finished(result));
  }

  @Override
  public void log(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Log");
    reporters.forEach(reporter -> reporter.log(logRecord));
  }

  @Override
  public void skipped(Executable executable, String reason) {
    LOGGER.log(Level.FINE, "Skipped executable");
    reporters.forEach(reporter -> reporter.skipped(executable, reason));
  }

  @Override
  public void skipped(Container container, String reason) {
    LOGGER.log(Level.FINE, "Skipped container");
    reporters.forEach(reporter -> reporter.skipped(container, reason));
  }

  @Override
  public void started(Executable executable) {
    LOGGER.log(Level.FINE, "Started executable");
    reporters.forEach(reporter -> reporter.started(executable));
  }

  @Override
  public void started(Root root) {
    LOGGER.log(Level.FINE, "Started root");
    reporters.forEach(reporter -> reporter.started(root));
  }

  @Override
  public void started(Container container) {
    LOGGER.log(Level.FINE, "Started container");
    reporters.forEach(reporter -> reporter.started(container));
  }

  private void addReporter(String name) {
    try {
      reporters.add((Reporter) Class.forName(name).getConstructors()[0].newInstance());
    } catch (ClassNotFoundException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      LOGGER.log(Level.WARNING, "Could not initiate the report class.", e);
    }
  }

  private static Properties loadProperties(File file) {
    var properties = new Properties();

    try (InputStream inputStream = new FileInputStream(file)) {
      properties.load(inputStream);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "The properties could not be loaded.", e);
    }

    return properties;
  }
}
