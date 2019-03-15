package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractIntArrayAssert;

class IntArrayAssertImpl<T extends IntArrayAssert<T>> extends EnumerableAssertImpl<int[], T>
    implements IntArrayAssert<T> {
  @Override
  AbstractIntArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
