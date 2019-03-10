package org.teacup.core;

import org.teacup.core.assertion.ObjectAssert;

/**
 * A node builder.
 *
 * @param <T> the actual type
 * @param <U> the node type
 * @since 1.0
 */
public interface NodeBuilder<T, U extends Node<T>, V extends NodeBuilder<T, U, V>> {
  /**
   * Build the node.
   *
   * @return the node
   */
  U build();

  /**
   * Sets the assertion.
   *
   * @param assertion the assertion
   * @return the node builder
   */
  V setAssertion(ObjectAssert<T, ?> assertion);
}
