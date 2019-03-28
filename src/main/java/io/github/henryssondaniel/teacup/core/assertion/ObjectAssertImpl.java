package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractAssert;

class ObjectAssertImpl<T, U extends ObjectAssert<T, U>> implements ObjectAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(ObjectAssertImpl.class.getName());
  private final Collection<Supplier> suppliers = new LinkedList<>();
  private T actual;

  @Override
  public U doesNotHaveSameClassAs(Object value) {
    LOGGER.log(Level.FINE, "Does not have the same class as: " + value);
    addSupplier(() -> getAssert().doesNotHaveSameClassAs(value));
    return getAssertType();
  }

  @Override
  public U hasSameClassAs(Object value) {
    LOGGER.log(Level.FINE, "Has the same class as: " + value);
    addSupplier(() -> getAssert().hasSameClassAs(value));
    return getAssertType();
  }

  @Override
  public U isEqualTo(Object value) {
    LOGGER.log(Level.FINE, "Is equal to: " + value);
    addSupplier(() -> getAssert().isEqualTo(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualTo(Object value) {
    LOGGER.log(Level.FINE, "Is not equal to: " + value);
    addSupplier(() -> getAssert().isNotEqualTo(value));
    return getAssertType();
  }

  @Override
  public U isNotSameAs(Object value) {
    LOGGER.log(Level.FINE, "Is not same as: " + value);
    addSupplier(() -> getAssert().isNotSameAs(value));

    return getAssertType();
  }

  @Override
  public U isSameAs(Object value) {
    LOGGER.log(Level.FINE, "Is same as: " + value);
    addSupplier(() -> getAssert().isSameAs(value));
    return getAssertType();
  }

  @Override
  public void verify(T actual) {
    LOGGER.log(Level.FINE, "Verify " + actual);
    this.actual = actual;
    suppliers.forEach(Supplier::get);
  }

  void addSupplier(Supplier supplier) {
    LOGGER.log(Level.FINE, "Adding supplier " + supplier);
    suppliers.add(supplier);
  }

  T getActual() {
    return actual;
  }

  AbstractAssert<?, T> getAssert() {
    return assertThat(actual);
  }

  @SuppressWarnings("unchecked")
  U getAssertType() {
    return (U) this;
  }
}
