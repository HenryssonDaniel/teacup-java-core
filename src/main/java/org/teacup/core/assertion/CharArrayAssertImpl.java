package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractCharArrayAssert;

class CharArrayAssertImpl<T extends CharArrayAssert<T>> extends EnumerableAssertImpl<char[], T>
    implements CharArrayAssert<T> {
  @Override
  AbstractCharArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
