package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class ListAssertImpl<T> extends AbstractListAssert<T, List<? extends T>, ListAssert<T>>
    implements ListAssert<T> {
  @Override
  org.assertj.core.api.AbstractListAssert<?, List<? extends T>, T, ?> getAssert() {
    return assertThat(getActual());
  }
}
