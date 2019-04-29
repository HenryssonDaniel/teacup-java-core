package io.github.henryssondaniel.teacup.core.testing;

/**
 * Container.
 *
 * @since 1.1
 */
public interface Container extends Executable {
  /**
   * Returns the cases.
   *
   * @return the cases
   * @since 1.1
   */
  Iterable<Case> getCases();

  /**
   * Returns the suites.
   *
   * @return the suites
   */
  Iterable<Suite> getSuites();
}
