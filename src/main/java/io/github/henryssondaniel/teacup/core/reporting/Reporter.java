package io.github.henryssondaniel.teacup.core.reporting;

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
   * @param testCase the test case
   * @since 1.1
   */
  void finished(TestCase testCase);

  /**
   * Finished.
   *
   * @param testSuites the test suites
   */
  void finished(Iterable<? extends TestSuite> testSuites);

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
   */
  void skipped(String reason, TestCase testCase);

  /**
   * Started.
   *
   * @param testCase the test case
   * @since 1.1
   */
  void started(TestCase testCase);

  /**
   * Started.
   *
   * @param testSuites the test suites
   * @since 1.1
   */
  void started(Iterable<? extends TestSuite> testSuites);
}
