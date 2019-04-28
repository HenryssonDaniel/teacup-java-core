package io.github.henryssondaniel.teacup.core.reporting;

import java.util.Optional;

/**
 * Test result.
 *
 * @since 1.1
 */
public interface TestResult {
  /**
   * Retuns the test status.
   *
   * @return the test status
   * @since 1.1
   */
  TestStatus getTestStatus();

  /**
   * Returns an optional throwable.
   *
   * @return the optional throwable
   * @since 1.1
   */
  Optional<Throwable> getThrowable();
}
