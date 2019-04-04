package io.github.henryssondaniel.teacup.core;

import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Default implementation of the {@link NodeBuilder}.
 *
 * @param <T> the actual type
 * @param <U> the node type
 * @param <V> the node setter type
 * @param <X> the node builder type
 * @since 1.0
 */
public abstract class DefaultNodeBuilder<
        T, U extends Node<T>, V extends Node<T>, X extends NodeBuilder<T, U, X>>
    extends DefaultBuilder<U, V> implements NodeBuilder<T, U, X> {
  private static final Logger LOGGER = Logger.getLogger(DefaultNodeBuilder.class.getName());

  /**
   * Constructor.
   *
   * @param setter the setter
   * @since 1.0
   */
  protected DefaultNodeBuilder(V setter) {
    super(setter);
  }

  @SuppressWarnings("unchecked")
  @Override
  public X setAssertion(ObjectAssert<T, ?> assertion) {
    LOGGER.log(Level.FINE, "Setting the assertion");
    doAssertion(assertion);
    return (X) this;
  }

  /**
   * Define what should happen when {@link #setAssertion(ObjectAssert)} is called.
   *
   * @param assertion the assertion
   * @since 1.0
   */
  protected abstract void doAssertion(ObjectAssert<T, ?> assertion);
}
