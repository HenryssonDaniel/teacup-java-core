package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractDoubleArrayAssert;

class DoubleArrayAssertImpl extends EnumerableAssertImpl<double[], DoubleArrayAssert>
    implements DoubleArrayAssert {
  @Override
  AbstractDoubleArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
