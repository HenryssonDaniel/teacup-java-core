package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract boolean array assert.
 *
 * @param <T> the generic boolean array assert type
 * @since 1.0
 */
public abstract class AbstractBooleanArrayAssert<T extends GenericBooleanArrayAssert<T>>
    extends EnumerableAssertImpl<boolean[], T> implements GenericBooleanArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractBooleanArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
