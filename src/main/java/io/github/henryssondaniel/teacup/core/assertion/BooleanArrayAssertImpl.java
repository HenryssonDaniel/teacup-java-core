package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractBooleanArrayAssert;

class BooleanArrayAssertImpl<T extends BooleanArrayAssert<T>>
    extends EnumerableAssertImpl<boolean[], T> implements BooleanArrayAssert<T> {
  @Override
  AbstractBooleanArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
