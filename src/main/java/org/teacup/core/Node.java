package org.teacup.core;

/**
 * A node in a request/response message.
 *
 * @param <T> the actual type
 * @since 1.0
 */
@FunctionalInterface
public interface Node<T> {
  /**
   * Verifies the actual.
   *
   * @param actual the actual
   */
  void verify(T actual);
}
