package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

/**
 * Suite.
 *
 * @since 1.1
 */
public interface Suite extends Data {
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
}
