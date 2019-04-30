package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

/**
 * Has the same behavior as {@link Root}, with the addition that it contains a path. The container
 * should be used for everything that contains other container and/or executables, but is not an
 * executable itself. In JUnit, this can be a test class.
 *
 * @since 1.1
 */
public interface Container extends Root {
  /**
   * Returns the path.
   *
   * @return the path
   * @since 1.1
   */
  Path getPath();
}
