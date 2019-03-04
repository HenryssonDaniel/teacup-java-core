package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

class ObjectAssertImpl<T, U extends ObjectAssert<T, U>> implements ObjectAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(ObjectAssertImpl.class.getName());
  private final Collection<Supplier<T>> suppliers = new LinkedList<>();

  @Override
  public U doesNotHaveSameClassAs(Object value) {
    LOGGER.log(Level.FINE, "Does not have the same class as: " + value);
    addSupplier(actual -> assertThat(actual).doesNotHaveSameClassAs(value));
    return returnAssertType();
  }

  @Override
  public U hasSameClassAs(Object value) {
    LOGGER.log(Level.FINE, "Has the same class as: " + value);
    addSupplier(actual -> assertThat(actual).hasSameClassAs(value));
    return returnAssertType();
  }

  @Override
  public U isEqualTo(Object value) {
    LOGGER.log(Level.FINE, "Is equal to: " + value);
    addSupplier(actual -> assertThat(actual).isEqualTo(value));
    return returnAssertType();
  }

  @Override
  public U isNotEqualTo(Object value) {
    LOGGER.log(Level.FINE, "Is not equal to: " + value);
    addSupplier(actual -> assertThat(actual).isNotEqualTo(value));
    return returnAssertType();
  }

  @Override
  public U isNotSameAs(Object value) {
    LOGGER.log(Level.FINE, "Is not same as: " + value);
    addSupplier(actual -> assertThat(actual).isNotSameAs(value));

    return returnAssertType();
  }

  @Override
  public U isSameAs(Object value) {
    LOGGER.log(Level.FINE, "Is same as: " + value);
    addSupplier(actual -> assertThat(actual).isSameAs(value));
    return returnAssertType();
  }

  @Override
  public void verify(T actual) {
    LOGGER.log(Level.FINE, "Verify " + actual);
    suppliers.forEach(assertSupplier -> assertSupplier.get(actual));
  }

  void addSupplier(Supplier<T> supplier) {
    suppliers.add(supplier);
  }

  @SuppressWarnings("unchecked")
  U returnAssertType() {
    return (U) this;
  }
}
