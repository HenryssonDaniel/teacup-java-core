package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

class ComparableAssertImpl<T extends Comparable<? super T>, U extends ComparableAssert<T, U>>
    extends ObjectAssertImpl<T, U> implements ComparableAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(ComparableAssertImpl.class.getName());
  private static final String MESSAGE = "Is %s than%s: %s";

  @Override
  public U isGreaterThan(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "greater", "", value));
    addSupplier(actual -> assertThat(actual).isGreaterThan(value));
    return returnAssertType();
  }

  @Override
  public U isGreaterThanOrEqualTo(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "greater", " or equal to", value));
    addSupplier(actual -> assertThat(actual).isGreaterThanOrEqualTo(value));
    return returnAssertType();
  }

  @Override
  public U isLessThan(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "less", "", value));
    addSupplier(actual -> assertThat(actual).isLessThan(value));
    return returnAssertType();
  }

  @Override
  public U isLessThanOrEqualTo(T value) {
    LOGGER.log(Level.FINE, String.format(MESSAGE, "less", " or equal to", value));
    addSupplier(actual -> assertThat(actual).isLessThanOrEqualTo(value));
    return returnAssertType();
  }
}
