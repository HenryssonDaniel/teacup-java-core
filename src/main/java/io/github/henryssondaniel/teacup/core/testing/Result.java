package io.github.henryssondaniel.teacup.core.testing;

import java.util.Optional;

/**
 * Result.
 *
 * @since 1.1
 */
public interface Result {
  /**
   * Returns the status.
   *
   * @return the status
   * @since 1.1
   */
  Status getStatus();

  /**
   * Returns an optional throwable.
   *
   * @return the optional throwable
   * @since 1.1
   */
  Optional<Throwable> getThrowable();
}
