package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

/**
 * Case.
 *
 * @since 1.1
 */
public interface Case extends Data {
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
}
