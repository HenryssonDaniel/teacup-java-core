package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractDoubleArrayAssert;

class DoubleArrayAssertImpl<T extends DoubleArrayAssert<T>>
    extends EnumerableAssertImpl<double[], T> implements DoubleArrayAssert<T> {
  @Override
  AbstractDoubleArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
