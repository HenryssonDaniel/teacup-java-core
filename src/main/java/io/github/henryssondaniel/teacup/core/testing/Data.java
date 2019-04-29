package io.github.henryssondaniel.teacup.core.testing;

interface Data {
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
