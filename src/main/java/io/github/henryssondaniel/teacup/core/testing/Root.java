package io.github.henryssondaniel.teacup.core.testing;

/**
 * This is used to mark the root of a test execution. In JUnit it's called a TestPlan. It contains
 * the start/finish time, containers and executables.
 *
 * @since 1.1
 */
public interface Root {
  /**
   * Returns the containers.
   *
   * @return the containers
   */
  Iterable<Container> getContainers();

  /**
   * Returns the executables.
   *
   * @return the executables
   * @since 1.1
   */
  Iterable<Executable> getExecutables();

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
