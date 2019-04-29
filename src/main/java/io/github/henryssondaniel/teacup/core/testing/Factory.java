package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;
import java.util.Collection;
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

  /**
   * Creates a new case.
   *
   * @param name the name
   * @param path the path
   * @return the case
   * @since 1.1
   */
  public static Case createCase(String name, Path path) {
    LOGGER.log(Level.FINE, "Creating a new case.");
    return new CaseImpl(name, path);
  }

  /**
   * Creates a new plan.
   *
   * @param cases the cases
   * @param suites the cases
   * @return the plan
   * @since 1.1
   */
  public static Plan createPlan(
      Collection<? extends Case> cases, Collection<? extends Suite> suites) {
    LOGGER.log(Level.FINE, "Creating a new plan.");
    return new PlanImpl(cases, suites);
  }

  /**
   * Creates a new result.
   *
   * @param status the status
   * @param throwable the throwable
   * @return the result
   * @since 1.1
   */
  public static Result createResult(Status status, Throwable throwable) {
    LOGGER.log(Level.FINE, "Creating a new test result.");
    return new ResultImpl(status, throwable);
  }

  /**
   * Creates a new suite.
   *
   * @param cases the cases
   * @param path the path
   * @param suites the cases
   * @return the suite
   * @since 1.1
   */
  public static Suite createSuite(
      Collection<? extends Case> cases, Path path, Collection<? extends Suite> suites) {
    LOGGER.log(Level.FINE, "Creating a new suite.");
    return new SuiteImpl(cases, path, suites);
  }
}
