package org.teacup.core;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.ObjectAssert;

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
    implements NodeBuilder<T, U, X> {
  private static final Logger LOGGER = Logger.getLogger(DefaultNodeBuilder.class.getName());
  private V setter;

  /**
   * Constructor.
   *
   * @param setter the setter
   */
  protected DefaultNodeBuilder(V setter) {
    this.setter = setter;
  }

  @Override
  public U build() {
    LOGGER.log(Level.FINE, "Building");

    @SuppressWarnings("unchecked")
    var node = (U) setter;
    setter = createSetter();

    return node;
  }

  @SuppressWarnings("unchecked")
  @Override
  public X setAssertion(ObjectAssert<T, ?> assertion) {
    LOGGER.log(Level.FINE, "Setting the assertion");
    doAssertion(assertion);
    return (X) this;
  }

  protected abstract V createSetter();

  /**
   * Define what should happen when {@link #setAssertion(ObjectAssert)} is called.
   *
   * @param assertion the assertion
   */
  protected abstract void doAssertion(ObjectAssert<T, ?> assertion);

  /**
   * Returns the setter.
   *
   * @return the setter
   */
  protected V getSetter() {
    return setter;
  }
}
