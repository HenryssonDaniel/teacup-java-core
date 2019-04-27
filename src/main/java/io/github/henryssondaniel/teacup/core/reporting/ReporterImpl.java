package io.github.henryssondaniel.teacup.core.reporting;

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
  public void finished(TestCase testCase) {
    LOGGER.log(Level.FINE, "Finished test case");
    reporters.forEach(reporter -> reporter.finished(testCase));
  }

  @Override
  public void finished(Iterable<? extends TestSuite> testSuites) {
    LOGGER.log(Level.FINE, "Finished test suite");
    reporters.forEach(reporter -> reporter.finished(testSuites));
  }

  @Override
  public void log(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Log");
    reporters.forEach(reporter -> reporter.log(logRecord));
  }

  @Override
  public void skipped(String reason, TestCase testCase) {
    LOGGER.log(Level.FINE, "Skipped test case");
    reporters.forEach(reporter -> reporter.skipped(reason, testCase));
  }

  @Override
  public void started(TestCase testCase) {
    LOGGER.log(Level.FINE, "Started test case");
    reporters.forEach(reporter -> reporter.started(testCase));
  }

  @Override
  public void started(Iterable<? extends TestSuite> testSuites) {
    LOGGER.log(Level.FINE, "Started test suite");
    reporters.forEach(reporter -> reporter.started(testSuites));
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
