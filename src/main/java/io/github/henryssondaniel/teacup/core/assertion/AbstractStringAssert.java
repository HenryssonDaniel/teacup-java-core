package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract string assert.
 *
 * @param <T> the generic string assert type
 * @since 1.0
 */
public abstract class AbstractStringAssert<T extends GenericStringAssert<T>>
    extends AbstractCharSequenceAssert<String, T> implements GenericStringAssert<T> {
  private static final Logger LOGGER = Factory.getLogger(AbstractStringAssert.class);

  @Override
  public T isGreaterThan(String value) {
    LOGGER.log(Level.FINE, "Is greater than: {0}", value);
    addSupplier(() -> getAssert().isGreaterThan(value));
    return getAssertType();
  }

  @Override
  public T isGreaterThanOrEqualTo(String value) {
    LOGGER.log(Level.FINE, "Is greater than or equal to: {0}", value);
    addSupplier(() -> getAssert().isGreaterThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  public T isLessThan(String value) {
    LOGGER.log(Level.FINE, "Is less than: {0}", value);
    addSupplier(() -> getAssert().isLessThan(value));
    return getAssertType();
  }

  @Override
  public T isLessThanOrEqualTo(String value) {
    LOGGER.log(Level.FINE, "Is less than or equal to: {0}", value);
    addSupplier(() -> getAssert().isLessThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  org.assertj.core.api.AbstractStringAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
