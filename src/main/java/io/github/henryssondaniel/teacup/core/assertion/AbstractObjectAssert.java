package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractAssert;

/**
 * Abstract object assert.
 *
 * @param <T> the object type
 * @param <U> the generic object assert type
 * @since 1.0
 */
public abstract class AbstractObjectAssert<T, U extends GenericObjectAssert<T, U>>
    implements GenericObjectAssert<T, U> {
  private static final Logger LOGGER = Factory.getLogger(AbstractObjectAssert.class);
  private final Collection<Supplier> suppliers = new LinkedList<>();
  private T actual;

  @Override
  public U doesNotHaveSameClassAs(Object value) {
    LOGGER.log(Level.FINE, "Does not have the same class as: {0}", value);
    addSupplier(() -> getAssert().doesNotHaveSameClassAs(value));
    return getAssertType();
  }

  @Override
  public U hasSameClassAs(Object value) {
    LOGGER.log(Level.FINE, "Has the same class as: {0}", value);
    addSupplier(() -> getAssert().hasSameClassAs(value));
    return getAssertType();
  }

  @Override
  public U isEqualTo(Object value) {
    LOGGER.log(Level.FINE, "Is equal to: {0}", value);
    addSupplier(() -> getAssert().isEqualTo(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualTo(Object value) {
    LOGGER.log(Level.FINE, "Is not equal to: {0}", value);
    addSupplier(() -> getAssert().isNotEqualTo(value));
    return getAssertType();
  }

  @Override
  public U isNotSameAs(Object value) {
    LOGGER.log(Level.FINE, "Is not same as: {0}", value);
    addSupplier(() -> getAssert().isNotSameAs(value));

    return getAssertType();
  }

  @Override
  public U isSameAs(Object value) {
    LOGGER.log(Level.FINE, "Is same as: {0}", value);
    addSupplier(() -> getAssert().isSameAs(value));
    return getAssertType();
  }

  @Override
  public void verify(T actual) {
    LOGGER.log(Level.FINE, "Verify {0}", actual);
    this.actual = actual;
    suppliers.forEach(Supplier::get);
  }

  void addSupplier(Supplier supplier) {
    LOGGER.log(Level.FINE, "Adding supplier {0}", supplier);
    suppliers.add(supplier);
  }

  T getActual() {
    return actual;
  }

  @SuppressWarnings("unchecked")
  <V extends AbstractAssert<V, T>> AbstractAssert<V, T> getAssert() {
    return (AbstractAssert<V, T>) assertThat(actual);
  }

  @SuppressWarnings("unchecked")
  U getAssertType() {
    return (U) this;
  }
}
