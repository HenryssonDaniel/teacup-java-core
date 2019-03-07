package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractLongArrayAssert;

class LongArrayAssertImpl extends EnumerableAssertImpl<long[], LongArrayAssert>
    implements LongArrayAssert {
  @Override
  AbstractLongArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
