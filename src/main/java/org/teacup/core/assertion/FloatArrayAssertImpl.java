package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractFloatArrayAssert;

class FloatArrayAssertImpl<T extends FloatArrayAssert<T>> extends EnumerableAssertImpl<float[], T>
    implements FloatArrayAssert<T> {
  @Override
  AbstractFloatArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
