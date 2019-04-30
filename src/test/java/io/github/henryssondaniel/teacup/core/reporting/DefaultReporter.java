package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.core.testing.Container;
import io.github.henryssondaniel.teacup.core.testing.Executable;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Root;
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
  public void skipped(Executable executable, String reason) {
    LOGGER.log(Level.FINE, "Skipped");
    executable.getName();
  }

  @Override
  public void skipped(Container container, String reason) {
    LOGGER.log(Level.FINE, "Skipped");
    container.getTimeFinished();
  }

  @Override
  public void started(Executable executable) {
    LOGGER.log(Level.FINE, "Started");
    executable.getName();
  }

  @Override
  public void started(Root root) {
    LOGGER.log(Level.FINE, "Started");
    root.getTimeFinished();
  }

  @Override
  public void started(Container container) {
    LOGGER.log(Level.FINE, "Started");
    container.getTimeFinished();
  }
}
