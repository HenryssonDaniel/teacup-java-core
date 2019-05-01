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
   * @param result the result
   * @since 1.1
   */
  void finished(Result result);

  /**
   * Log.
   *
   * @param logRecord the log record
   * @since 1.1
   */
  void log(LogRecord logRecord);

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
   * @param nodes the nodes
   * @since 1.1
   */
  void started(Iterable<? extends Node> nodes);

  /**
   * Started.
   *
   * @param node the node
   * @since 1.1
   */
  void started(Node node);
}
