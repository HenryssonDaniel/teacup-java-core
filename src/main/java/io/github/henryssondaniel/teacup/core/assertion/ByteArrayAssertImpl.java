package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractByteArrayAssert;

class ByteArrayAssertImpl<T extends ByteArrayAssert<T>> extends EnumerableAssertImpl<byte[], T>
    implements ByteArrayAssert<T> {
  @Override
  AbstractByteArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
