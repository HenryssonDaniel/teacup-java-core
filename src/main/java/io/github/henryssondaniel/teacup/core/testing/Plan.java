package io.github.henryssondaniel.teacup.core.testing;

/**
 * Plan.
 *
 * @since 1.1
 */
public interface Plan {
  /**
   * Returns the data.
   *
   * @return the data
   * @since 1.1
   */
  Iterable<Data> getData();

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
