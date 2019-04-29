package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.core.testing.Data;
import io.github.henryssondaniel.teacup.core.testing.Plan;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DefaultReporter implements Reporter {
  private static final Logger LOGGER = Factory.getLogger(DefaultReporter.class);

  @Override
  public void finished(Data data, Result result) {
    LOGGER.log(Level.FINE, "Finished");
    data.getName();
  }

  @Override
  public void finished(Plan plan) {
    LOGGER.log(Level.FINE, "Finished");
    plan.getTimeFinished();
  }

  @Override
  public void log(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Log");
    logRecord.getMessage();
  }

  @Override
  public void skipped(Data data, String reason) {
    LOGGER.log(Level.FINE, "Skipped");
    data.getName();
  }

  @Override
  public void started(Data data) {
    LOGGER.log(Level.FINE, "Started");
    data.getName();
  }

  @Override
  public void started(Plan plan) {
    LOGGER.log(Level.FINE, "Started");
    plan.getTimeFinished();
  }
}
