package io.github.henryssondaniel.teacup.core.logging;

import io.github.henryssondaniel.teacup.core.reporting.Factory;
import io.github.henryssondaniel.teacup.core.reporting.Reporter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class ReporterHandlerImpl extends Handler {
  private static final Logger LOGGER = Logger.getLogger(ReporterHandlerImpl.class.getName());
  private static final Reporter REPORTER = Factory.createReporter();

  @Override
  public void close() {
    LOGGER.log(Level.FINE, "Close");
  }

  @Override
  public void flush() {
    LOGGER.log(Level.FINE, "Flush");
  }

  @Override
  public void publish(LogRecord logRecord) {
    LOGGER.log(Level.FINE, "Publish");
    REPORTER.log(logRecord);
  }
}
