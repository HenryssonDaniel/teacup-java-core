package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract char array assert.
 *
 * @param <T> the generic char array assert type
 * @since 1.0
 */
public abstract class AbstractCharArrayAssert<T extends GenericCharArrayAssert<T>>
    extends EnumerableAssertImpl<char[], T> implements GenericCharArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractCharArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
