package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.ObjectArrayAssert;

/**
 * Abstract object array assert.
 *
 * @param <T> the generic object array assert type
 * @since 1.0
 */
public abstract class AbstractObjectArrayAssert<T, U extends GenericObjectArrayAssert<T, U>>
    extends EnumerableAssertImpl<T[], U> implements GenericObjectArrayAssert<T, U> {
  @Override
  @SuppressWarnings("unchecked")
  ObjectArrayAssert<T> getAssert() {
    return assertThat(getActual());
  }
}
