package io.github.henryssondaniel.teacup.core.testing;

/**
 * Case.
 *
 * @since 1.1
 */
public interface Case extends Executable, Physical {
  /**
   * Returns the name.
   *
   * @return the name
   * @since 1.1
   */
  String getName();
}
