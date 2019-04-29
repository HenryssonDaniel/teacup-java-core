package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Case;
import io.github.henryssondaniel.teacup.core.testing.Plan;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Suite;
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
   * @param reason the reason
   * @param testCase the test case
   * @since 1.1
   */
  void skipped(String reason, Case testCase);

  /**
   * Skipped.
   *
   * @param reason the reason
   * @param suite the suite
   * @since 1.1
   */
  void skipped(String reason, Suite suite);

  /**
   * Started.
   *
   * @param testCase the test case
   * @since 1.1
   */
  void started(Case testCase);

  /**
   * Started.
   *
   * @param plan the plan
   * @since 1.1
   */
  void started(Plan plan);

  /**
   * Started.
   *
   * @param suite the suite
   * @since 1.1
   */
  void started(Suite suite);
}
