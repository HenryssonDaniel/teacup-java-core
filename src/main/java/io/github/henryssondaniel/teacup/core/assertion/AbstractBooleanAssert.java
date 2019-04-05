package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract boolean assert.
 *
 * @param <T> the generic boolean assert type
 * @since 1.0
 */
public abstract class AbstractBooleanAssert<T extends GenericBooleanAssert<T>>
    extends AbstractObjectAssert<Boolean, T> implements GenericBooleanAssert<T> {
  private static final Logger LOGGER = Logger.getLogger(AbstractBooleanAssert.class.getName());

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
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractBooleanAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
