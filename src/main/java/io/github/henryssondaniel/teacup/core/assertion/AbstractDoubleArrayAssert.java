package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract double array assert.
 *
 * @param <T> the generic double array assert type
 * @since 1.0
 */
public abstract class AbstractDoubleArrayAssert<T extends GenericDoubleArrayAssert<T>>
    extends EnumerableAssertImpl<double[], T> implements GenericDoubleArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractDoubleArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
