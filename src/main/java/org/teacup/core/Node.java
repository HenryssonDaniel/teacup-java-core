package org.teacup.core;

import org.teacup.core.assertion.ObjectAssert;

/**
 * A node in a request/response message.
 *
 * @param <T> the actual type
 * @since 1.0
 */
public interface Node<T> {
  /**
   * Returns the assertion.
   *
   * @return the assertion
   */
  ObjectAssert<T, ?> getAssertion();

  /**
   * Verifies the actual.
   *
   * @param actual the actual
   */
  void verify(T actual);
}
