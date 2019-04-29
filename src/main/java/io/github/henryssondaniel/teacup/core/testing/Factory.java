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
   * Creates a new data.
   *
   * @param name the name
   * @param path the path
   * @param type the type
   * @return the data
   * @since 1.1
   */
  public static Data createData(String name, Path path, Type type) {
    LOGGER.log(Level.FINE, "Creating a new data.");
    return new DataImpl(name, path, type);
  }

  /**
   * Creates a new plan.
   *
   * @param data the data
   * @return the plan
   * @since 1.1
   */
  public static Plan createPlan(Collection<? extends Data> data) {
    LOGGER.log(Level.FINE, "Creating a new plan.");
    return new PlanImpl(data);
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
}
