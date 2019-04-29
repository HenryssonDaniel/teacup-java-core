package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Data;
import io.github.henryssondaniel.teacup.core.testing.Plan;
import io.github.henryssondaniel.teacup.core.testing.Result;
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
  public void finished(Data data, Result result) {
    LOGGER.log(Level.FINE, "Finished data");
    reporters.forEach(reporter -> reporter.finished(data, result));
  }

  @Override
  public void finished(Plan plan) {
    LOGGER.log(Level.FINE, "Finished plan");
    reporters.forEach(reporter -> reporter.finished(plan));
  }

  @Override
  public void log(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Log");
    reporters.forEach(reporter -> reporter.log(logRecord));
  }

  @Override
  public void skipped(Data data, String reason) {
    LOGGER.log(Level.FINE, "Skipped data");
    reporters.forEach(reporter -> reporter.skipped(data, reason));
  }

  @Override
  public void started(Data data) {
    LOGGER.log(Level.FINE, "Started data");
    reporters.forEach(reporter -> reporter.started(data));
  }

  @Override
  public void started(Plan plan) {
    LOGGER.log(Level.FINE, "Started plan");
    reporters.forEach(reporter -> reporter.started(plan));
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
