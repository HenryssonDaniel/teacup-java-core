package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

class ReporterImpl implements Reporter {
  private static final Logger LOGGER = Logger.getLogger(ReporterImpl.class.getName());

  private final Collection<Reporter> reporters = new LinkedList<>();
  private final Map<Long, LinkedList<Node>> runningTests = new HashMap<>(0);

  ReporterImpl(File file) {
    if (file.exists()) {
      var property = loadProperties(file).getProperty("reporter");

      if (property != null && !property.isEmpty())
        for (var name : property.split(",")) addReporter(name);
    }
  }

  @Override
  public void added(Node node) {
    LOGGER.log(Level.FINE, "Added");
    reporters.forEach(reporter -> reporter.added(node));
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
  public void initialized(Iterable<? extends Node> nodes) {
    LOGGER.log(Level.FINE, "Initialized");
    reporters.forEach(reporter -> reporter.initialized(nodes));
  }

  @Override
  public void log(LogRecord logRecord, Node node) {
    LOGGER.log(Level.FINE, "Log");

    if (!reporters.isEmpty()) {
      var lastNode =
          Optional.ofNullable(runningTests.get(Thread.currentThread().getId()))
              .map(LinkedList::getLast)
              .orElse(null);
      reporters.forEach(reporter -> reporter.log(logRecord, lastNode));
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

  private void removeNode(Node node) {
    Long id = Thread.currentThread().getId();

    Collection<Node> nodes = runningTests.get(id);
    if (nodes != null) {
      nodes.remove(node);

      if (nodes.isEmpty()) runningTests.remove(id);
    }
  }
}
