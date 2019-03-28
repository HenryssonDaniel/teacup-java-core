package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractBooleanAssert;

class BooleanAssertImpl<T extends BooleanAssert<T>> extends ObjectAssertImpl<Boolean, T>
    implements BooleanAssert<T> {
  private static final Logger LOGGER = Logger.getLogger(BooleanAssertImpl.class.getName());

  @Override
  public T isFalse() {
    LOGGER.log(Level.FINE, "Is false");
    addSupplier(() -> getAssert().isFalse());
    return getAssertType();
  }

  @Override
  public T isTrue() {
    LOGGER.log(Level.FINE, "Is true");
    addSupplier(() -> getAssert().isTrue());
    return getAssertType();
  }

  @Override
  AbstractBooleanAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
