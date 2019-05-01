package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
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
  public void skipped(Node node, String reason) {
    LOGGER.log(Level.FINE, "Skipped");
    node.getName();
  }

  @Override
  public void started(Node node) {
    LOGGER.log(Level.FINE, "Started");
    node.getName();
  }

  @Override
  public void started(Iterable<? extends Node> nodes) {
    LOGGER.log(Level.FINE, "Started");
    nodes.forEach(Node::getName);
  }
}
