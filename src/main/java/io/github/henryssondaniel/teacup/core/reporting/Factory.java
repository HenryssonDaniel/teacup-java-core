package io.github.henryssondaniel.teacup.core.reporting;

import java.nio.file.Path;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory.
 *
 * @since 1.1
 */
public enum Factory {
  ;

  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());
  private static final Reporter REPORTER =
      new ReporterImpl(
          Path.of(System.getProperty("user.home"))
              .resolve(".teacup")
              .resolve("teacup.properties")
              .toFile());

  /**
   * Creates a new reporter.
   *
   * @return the reporter
   * @since 1.1
   */
  public static Reporter createReporter() {
    LOGGER.log(Level.FINE, "Creating a new reporter.");
    return REPORTER;
  }

  /**
   * Creates a new test case.
   *
   * @param name the name
   * @param path the path
   * @return the test case
   * @since 1.1
   */
  public static TestCase createTestCase(String name, Path path) {
    LOGGER.log(Level.FINE, "Creating a new test case.");
    return new TestCaseImpl(name, path);
  }

  /**
   * Creates a new test suite.
   *
   * @param name the name
   * @param testCases the test cases
   * @return the test suite
   * @since 1.1
   */
  public static TestSuite createTestSuite(String name, Set<TestCase> testCases) {
    LOGGER.log(Level.FINE, "Creating a new test suite.");
    return new TestSuiteImpl(name, testCases);
  }
}
