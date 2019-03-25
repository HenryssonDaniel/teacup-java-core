package org.teacup.core;

import org.teacup.core.assertion.ObjectAssert;

/**
 * Node builder.
 *
 * @param <T> the actual type
 * @param <U> the node type
 * @param <V> the node builder type
 * @since 1.0
 */
public interface NodeBuilder<T, U extends Node<T>, V extends NodeBuilder<T, U, V>>
    extends Builder<U> {
  /**
   * Sets the assertion.
   *
   * @param assertion the assertion
   * @return the node builder
   */
  V setAssertion(ObjectAssert<T, ?> assertion);
}
