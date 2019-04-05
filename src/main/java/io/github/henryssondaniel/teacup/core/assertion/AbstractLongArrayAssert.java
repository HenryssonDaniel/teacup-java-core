package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract long array assert.
 *
 * @param <T> the generic long array assert type
 * @since 1.0
 */
public abstract class AbstractLongArrayAssert<T extends GenericLongArrayAssert<T>>
    extends EnumerableAssertImpl<long[], T> implements GenericLongArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractLongArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
