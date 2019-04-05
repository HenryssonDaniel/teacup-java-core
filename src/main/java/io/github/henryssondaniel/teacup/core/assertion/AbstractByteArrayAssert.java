package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract byte array assert.
 *
 * @param <T> the generic byte array assert type
 * @since 1.0
 */
public abstract class AbstractByteArrayAssert<T extends GenericByteArrayAssert<T>>
    extends EnumerableAssertImpl<byte[], T> implements GenericByteArrayAssert<T> {
  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractByteArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
