package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

/**
 * Suite.
 *
 * @since 1.1
 */
public interface Suite {
  /**
   * Returns the cases.
   *
   * @return the cases
   * @since 1.1
   */
  Iterable<Case> getCases();

  /**
   * Returns the path.
   *
   * @return the path
   * @since 1.1
   */
  Path getPath();

  /**
   * Returns the suites.
   *
   * @return the suites
   */
  Iterable<Suite> getSuites();

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
