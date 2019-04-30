package io.github.henryssondaniel.teacup.core.testing;

/**
 * Has the same behavior as {@link Container}, with the addition that it contains a name. The
 * executable should be used for everything that can be executed as a test. This includes tests that
 * contains other tests, or containers. In JUnit, this can be a test method.
 *
 * @since 1.1
 */
public interface Executable extends Container {
  /**
   * Returns the name.
   *
   * @return the name
   * @since 1.1
   */
  String getName();
}
