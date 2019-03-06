package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractStringAssert;

class StringAssertImpl extends CharSequenceAssertImpl<String, StringAssert>
    implements StringAssert {
  private static final Logger LOGGER = Logger.getLogger(StringAssertImpl.class.getName());

  @Override
  public StringAssert isGreaterThan(String value) {
    LOGGER.log(Level.FINE, "Is greater than: " + value);
    addSupplier(() -> getAssert().isGreaterThan(value));
    return this;
  }

  @Override
  public StringAssert isGreaterThanOrEqualTo(String value) {
    LOGGER.log(Level.FINE, "Is greater than or equal to: " + value);
    addSupplier(() -> getAssert().isGreaterThanOrEqualTo(value));
    return this;
  }

  @Override
  public StringAssert isLessThan(String value) {
    LOGGER.log(Level.FINE, "Is less than: " + value);
    addSupplier(() -> getAssert().isLessThan(value));
    return this;
  }

  @Override
  public StringAssert isLessThanOrEqualTo(String value) {
    LOGGER.log(Level.FINE, "Is less than or equal to: " + value);
    addSupplier(() -> getAssert().isLessThanOrEqualTo(value));
    return this;
  }

  @Override
  AbstractStringAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
