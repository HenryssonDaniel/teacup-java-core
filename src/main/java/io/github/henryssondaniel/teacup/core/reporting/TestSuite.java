package io.github.henryssondaniel.teacup.core.reporting;

/**
 * Test suite.
 *
 * @since 1.1
 */
public interface TestSuite {
  /**
   * Returns the name.
   *
   * @return the name
   * @since 1.1
   */
  String getName();

  /**
   * Returns the test cases.
   *
   * @return the test cases
   * @since 1.1
   */
  Iterable<TestCase> getTestCases();
}
