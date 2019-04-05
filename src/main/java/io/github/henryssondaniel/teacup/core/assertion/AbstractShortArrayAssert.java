package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract short array assert.
 *
 * @param <T> the generic short array assert type
 * @since 1.0
 */
public abstract class AbstractShortArrayAssert<T extends GenericShortArrayAssert<T>>
    extends EnumerableAssertImpl<short[], T> implements GenericShortArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractShortArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
