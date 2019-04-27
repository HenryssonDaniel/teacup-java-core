package io.github.henryssondaniel.teacup.core.reporting;

import java.nio.file.Path;

/**
 * Test case.
 *
 * @since 1.1
 */
public interface TestCase {
  /**
   * Returns the name.
   *
   * @return the name
   * @since 1.1
   */
  String getName();

  /**
   * Returns the path.
   *
   * @return the path
   * @since 1.1
   */
  Path getPath();

  /**
   * Return the test status.
   *
   * @return the test status
   * @since 1.1
   */
  TestStatus getTestStatus();

  /**
   * Returns the time finished.
   *
   * @return the time finished
   * @since 1.1
   */
  long getTimeFinished();

  /**
   * Returns the time started.
   *
   * @return the time started
   * @since 1.1
   */
  long getTimeStarted();

  /**
   * Sets the test status.
   *
   * @param testStatus the test status
   * @since 1.1
   */
  void setTestStatus(TestStatus testStatus);

  /**
   * Sets the time finished.
   *
   * @param timeFinished the time finished
   * @since 1.1
   */
  void setTimeFinished(long timeFinished);

  /**
   * Sets the time started.
   *
   * @param timeStarted the time started
   * @since 1.1
   */
  void setTimeStarted(long timeStarted);
}
