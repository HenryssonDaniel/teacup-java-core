package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.core.testing.Case;
import io.github.henryssondaniel.teacup.core.testing.Plan;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Suite;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DefaultReporter implements Reporter {
  private static final Logger LOGGER = Factory.getLogger(DefaultReporter.class);

  @Override
  public void finished(Result result) {
    LOGGER.log(Level.FINE, "Finished");
    result.getStatus();
  }

  @Override
  public void log(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Log");
    logRecord.getMessage();
  }

  @Override
  public void skipped(String reason, Case testCase) {
    LOGGER.log(Level.FINE, "Skipped");
    testCase.getName();
  }

  @Override
  public void skipped(String reason, Suite suite) {
    LOGGER.log(Level.FINE, "Skipped");
    suite.getTimeFinished();
  }

  @Override
  public void started(Case testCase) {
    LOGGER.log(Level.FINE, "Started");
    testCase.getName();
  }

  @Override
  public void started(Plan plan) {
    LOGGER.log(Level.FINE, "Started");
    plan.getTimeFinished();
  }

  @Override
  public void started(Suite suite) {
    LOGGER.log(Level.FINE, "Started");
    suite.getTimeFinished();
  }
}
