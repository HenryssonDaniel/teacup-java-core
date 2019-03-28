package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractLongArrayAssert;

class LongArrayAssertImpl<T extends LongArrayAssert<T>> extends EnumerableAssertImpl<long[], T>
    implements LongArrayAssert<T> {
  @Override
  AbstractLongArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
