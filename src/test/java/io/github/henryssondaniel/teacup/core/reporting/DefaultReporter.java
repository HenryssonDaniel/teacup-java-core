package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class DefaultReporter implements Reporter {
  private static final Logger LOGGER = Factory.getLogger(DefaultReporter.class);
  private Iterable<? extends Node> allNodes;

  @Override
  public void finished(Node node, Result result) {
    LOGGER.log(Level.FINE, "Finished");
    result.getStatus();
  }

  @Override
  public void initialize() {
    LOGGER.log(Level.FINE, "Initialize");
  }

  @Override
  public void initialized(Collection<? extends Node> nodes) {
    LOGGER.log(Level.FINE, "Initialized");

    allNodes = nodes;
    nodes.forEach(Node::getName);
  }

  @Override
  public void log(LogRecord logRecord, Node node) {
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
  public void terminated() {
    LOGGER.log(Level.FINE, "Terminated");
    allNodes.forEach(Node::getName);
  }
}
