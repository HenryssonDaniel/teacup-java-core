package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractObjectArrayAssert;

class ObjectArrayAssertImpl<T> extends EnumerableAssertImpl<T[], ObjectArrayAssert<T>>
    implements ObjectArrayAssert<T> {
  @Override
  AbstractObjectArrayAssert<?, T> getAssert() {
    return assertThat(getActual());
  }
}
