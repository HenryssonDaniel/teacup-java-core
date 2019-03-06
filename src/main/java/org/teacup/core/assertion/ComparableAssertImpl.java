package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractComparableAssert;

class ComparableAssertImpl<T extends Comparable<? super T>, U extends ComparableAssert<T, U>>
    extends ObjectAssertImpl<T, U> implements ComparableAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(ComparableAssertImpl.class.getName());
  private static final String MESSAGE = "Is %s than%s: %s";

  @Override
  public U isGreaterThan(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "greater", "", value));
    addSupplier(() -> getAssert().isGreaterThan(value));
    return getAssertType();
  }

  @Override
  public U isGreaterThanOrEqualTo(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "greater", " or equal to", value));
    addSupplier(() -> getAssert().isGreaterThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  public U isLessThan(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "less", "", value));
    addSupplier(() -> getAssert().isLessThan(value));
    return getAssertType();
  }

  @Override
  public U isLessThanOrEqualTo(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "less", " or equal to", value));
    addSupplier(() -> getAssert().isLessThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  AbstractComparableAssert<?, T> getAssert() {
    return assertThat(getActual());
  }
}
