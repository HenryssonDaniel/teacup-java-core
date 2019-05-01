package io.github.henryssondaniel.teacup.core.testing;

/**
 * Represents a node in a test. This can be either a container, a test or both.
 *
 * @since 1.1
 */
public interface Node {
  /**
   * Returns the name.
   *
   * @return the name
   * @since 1.1
   */
  String getName();

  /**
   * Returns the test nodes.
   *
   * @return the test nodes
   */
  Iterable<Node> getNodes();

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
