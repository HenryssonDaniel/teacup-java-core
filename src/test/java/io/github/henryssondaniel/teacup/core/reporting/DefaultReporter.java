package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DefaultReporter implements Reporter {
  private static final Logger LOGGER = Factory.getLogger(DefaultReporter.class);

  @Override
  public void finished(TestCase testCase) {
    LOGGER.log(Level.FINE, "Finished");
    testCase.getName();
  }

  @Override
  public void finished(Iterable<? extends TestSuite> testSuites) {
    LOGGER.log(Level.FINE, "Finished");
    testSuites.forEach(TestSuite::getName);
  }

  @Override
  public void log(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Log");
    logRecord.getMessage();
  }

  @Override
  public void skipped(String reason, TestCase testCase) {
    LOGGER.log(Level.FINE, "Skipped");
    testCase.getName();
  }

  @Override
  public void started(TestCase testCase) {
    LOGGER.log(Level.FINE, "Started");
    testCase.getName();
  }

  @Override
  public void started(Iterable<? extends TestSuite> testSuites) {
    LOGGER.log(Level.FINE, "Started");
    testSuites.forEach(TestSuite::getName);
  }
}
