package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

/**
 * Data.
 *
 * @since 1.1
 */
public interface Data {
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
   * Returns the type.
   *
   * @return the type
   * @since 1.1
   */
  Type getType();

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
