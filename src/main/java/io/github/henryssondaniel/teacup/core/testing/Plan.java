package io.github.henryssondaniel.teacup.core.testing;

/**
 * Plan.
 *
 * @since 1.1
 */
public interface Plan extends Data {
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
