package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

class IterableAssertImpl<T>
    extends AbstractIterableAssert<T, Iterable<? extends T>, IterableAssert<T>>
    implements IterableAssert<T> {
  @Override
  org.assertj.core.api.AbstractIterableAssert<?, Iterable<? extends T>, T, ?> getAssert() {
    return assertThat(getActual());
  }
}
