package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.util.logging.LogRecord;

/**
 * Reporter.
 *
 * @since 1.1
 */
public interface Reporter {
  /**
   * Finished.
   *
   * @param node the node
   * @param result the result
   * @since 1.1
   */
  void finished(Node node, Result result);

  /**
   * Initialize.
   *
   * @since 1.1
   */
  void initialize();

  /**
   * Initialized.
   *
   * @param nodes the nodes
   * @since 1.1
   */
  void initialized(Iterable<? extends Node> nodes);

  /**
   * Log.
   *
   * @param logRecord the log record
   * @param node the node
   * @since 1.1
   */
  void log(LogRecord logRecord, Node node);

  /**
   * Skipped.
   *
   * @param node the node
   * @param reason the reason
   * @since 1.1
   */
  void skipped(Node node, String reason);

  /**
   * Started.
   *
   * @param node the node
   * @since 1.1
   */
  void started(Node node);

  /**
   * Terminated.
   *
   * @since 1.1
   */
  void terminated();
}
