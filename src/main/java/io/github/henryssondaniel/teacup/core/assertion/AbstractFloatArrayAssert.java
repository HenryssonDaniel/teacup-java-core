package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract float array assert.
 *
 * @param <T> the generic float array assert type
 * @since 1.0
 */
public abstract class AbstractFloatArrayAssert<T extends GenericFloatArrayAssert<T>>
    extends EnumerableAssertImpl<float[], T> implements GenericFloatArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractFloatArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
