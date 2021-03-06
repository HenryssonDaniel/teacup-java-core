package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class ReporterImpl implements Reporter {
  private static final Logger LOGGER = Logger.getLogger(ReporterImpl.class.getName());

  private final String property;
  private final Collection<Reporter> reporters = new LinkedList<>();
  private final Map<Long, LinkedList<Node>> runningTests = new HashMap<>(0);

  ReporterImpl(String property) {
    this.property = property;
  }

  @Override
  public void finished(Node node, Result result) {
    LOGGER.log(Level.FINE, "Finished");

    if (!reporters.isEmpty()) {
      removeNode(node);
      reporters.forEach(reporter -> reporter.finished(node, result));
    }
  }

  @Override
  public void initialize() {
    LOGGER.log(Level.FINE, "Initialize");

    if (property != null && !property.isEmpty())
      for (var name : property.split(",")) addReporter(name);
  }

  @Override
  public void initialized(Collection<? extends Node> nodes) {
    LOGGER.log(Level.FINE, "Initialized");
    reporters.forEach(reporter -> reporter.initialized(nodes));
  }

  @Override
  public void log(LogRecord logRecord, Node node) {
    LOGGER.log(Level.FINE, "Log");

    if (!reporters.isEmpty()) {
      var currentNode = Optional.ofNullable(node).orElseGet(this::getCurrentNode);

      reporters.forEach(reporter -> reporter.log(logRecord, currentNode));
    }
  }

  @Override
  public void skipped(Node node, String reason) {
    LOGGER.log(Level.FINE, "Skipped");
    reporters.forEach(reporter -> reporter.skipped(node, reason));
  }

  @Override
  public void started(Node node) {
    LOGGER.log(Level.FINE, "Started");

    if (!reporters.isEmpty()) {
      runningTests
          .computeIfAbsent(Thread.currentThread().getId(), key -> new LinkedList<>())
          .add(node);

      reporters.forEach(reporter -> reporter.started(node));
    }
  }

  @Override
  public void terminated() {
    LOGGER.log(Level.FINE, "Terminated");

    if (!runningTests.isEmpty()) {
      LOGGER.log(Level.WARNING, "Terminated when not all nodes have been finished.");
      runningTests.clear();
    }

    reporters.forEach(Reporter::terminated);
  }

  private void addReporter(String name) {
    try {
      var reporter = (Reporter) Class.forName(name).getConstructors()[0].newInstance();
      reporter.initialize();

      reporters.add(reporter);
    } catch (ClassNotFoundException
        | IllegalAccessException
        | InstantiationException
        | InvocationTargetException e) {
      LOGGER.log(Level.WARNING, "Could not initiate the report class.", e);
    }
  }

  private Node getCurrentNode() {
    Node node = null;

    var id = Thread.currentThread().getId();
    var threads = new Thread[Thread.activeCount()];

    var index = Thread.enumerate(threads) - 1;

    while (index >= 0) {
      var threadId = threads[index].getId();

      if (threadId <= id) {
        var nodes = runningTests.get(threadId);

        if (nodes != null) {
          node = nodes.getLast();
          index = 0;
        }
      }

      index--;
    }

    return node;
  }

  private void removeNode(Node node) {
    Long id = Thread.currentThread().getId();

    Collection<Node> nodes = runningTests.get(id);
    if (nodes != null) {
      nodes.remove(node);

      if (nodes.isEmpty()) runningTests.remove(id);
    }
  }
}
