package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Data;
import io.github.henryssondaniel.teacup.core.testing.Plan;
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
   * @param data the data
   * @param result the result
   * @since 1.1
   */
  void finished(Data data, Result result);

  /**
   * Finished.
   *
   * @param plan the plan
   * @since 1.1
   */
  void finished(Plan plan);

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
   * @param data the data
   * @param reason the reason
   * @since 1.1
   */
  void skipped(Data data, String reason);

  /**
   * Started.
   *
   * @param data the data
   * @since 1.1
   */
  void started(Data data);

  /**
   * Started.
   *
   * @param plan the plan
   * @since 1.1
   */
  void started(Plan plan);
}
