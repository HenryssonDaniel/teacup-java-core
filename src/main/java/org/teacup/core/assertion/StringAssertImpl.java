package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractStringAssert;

class StringAssertImpl<T extends StringAssert<T>> extends CharSequenceAssertImpl<String, T>
    implements StringAssert<T> {
  private static final Logger LOGGER = Logger.getLogger(StringAssertImpl.class.getName());

  @Override
  public T isGreaterThan(String value) {
    LOGGER.log(Level.FINE, "Is greater than: " + value);
    addSupplier(() -> getAssert().isGreaterThan(value));
    return getAssertType();
  }

  @Override
  public T isGreaterThanOrEqualTo(String value) {
    LOGGER.log(Level.FINE, "Is greater than or equal to: " + value);
    addSupplier(() -> getAssert().isGreaterThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  public T isLessThan(String value) {
    LOGGER.log(Level.FINE, "Is less than: " + value);
    addSupplier(() -> getAssert().isLessThan(value));
    return getAssertType();
  }

  @Override
  public T isLessThanOrEqualTo(String value) {
    LOGGER.log(Level.FINE, "Is less than or equal to: " + value);
    addSupplier(() -> getAssert().isLessThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  AbstractStringAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
