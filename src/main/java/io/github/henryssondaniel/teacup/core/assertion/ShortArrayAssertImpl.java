package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractShortArrayAssert;

class ShortArrayAssertImpl<T extends ShortArrayAssert<T>> extends EnumerableAssertImpl<short[], T>
    implements ShortArrayAssert<T> {
  @Override
  AbstractShortArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
