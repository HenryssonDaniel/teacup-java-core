package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractObjectArrayAssert;

class ObjectArrayAssertImpl<T, U extends ObjectArrayAssert<T, U>>
    extends EnumerableAssertImpl<T[], U> implements ObjectArrayAssert<T, U> {
  @Override
  AbstractObjectArrayAssert<?, T> getAssert() {
    return assertThat(getActual());
  }
}
