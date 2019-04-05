package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract comparable assert.
 *
 * @param <T> the comparable type
 * @param <U> the generic comparable assert type
 * @since 1.0
 */
public abstract class AbstractComparableAssert<
        T extends Comparable<? super T>, U extends GenericComparableAssert<T, U>>
    extends AbstractObjectAssert<T, U> implements GenericComparableAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(AbstractComparableAssert.class.getName());
  private static final String MESSAGE = "Is {0} than{1}: {2}";

  @Override
  public U isGreaterThan(T value) {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"greater", "", value});
    addSupplier(() -> getAssert().isGreaterThan(value));
    return getAssertType();
  }

  @Override
  public U isGreaterThanOrEqualTo(T value) {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"greater", " or equal to", value});
    addSupplier(() -> getAssert().isGreaterThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  public U isLessThan(T value) {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"less", "", value});
    addSupplier(() -> getAssert().isLessThan(value));
    return getAssertType();
  }

  @Override
  public U isLessThanOrEqualTo(T value) {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"less", " or equal to", value});
    addSupplier(() -> getAssert().isLessThanOrEqualTo(value));
    return getAssertType();
  }

  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractComparableAssert<?, T> getAssert() {
    return assertThat(getActual());
  }
}
