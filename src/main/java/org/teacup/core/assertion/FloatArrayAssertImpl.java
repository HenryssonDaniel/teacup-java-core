package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractFloatArrayAssert;

class FloatArrayAssertImpl extends EnumerableAssertImpl<float[], FloatArrayAssert>
    implements FloatArrayAssert {
  @Override
  AbstractFloatArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
