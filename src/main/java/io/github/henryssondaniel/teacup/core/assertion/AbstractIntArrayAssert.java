package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract int array assert.
 *
 * @param <T> the generic int array assert type
 * @since 1.0
 */
public abstract class AbstractIntArrayAssert<T extends GenericIntArrayAssert<T>>
    extends EnumerableAssertImpl<int[], T> implements GenericIntArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractIntArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
