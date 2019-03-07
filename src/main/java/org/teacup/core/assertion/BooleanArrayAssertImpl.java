package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractBooleanArrayAssert;

class BooleanArrayAssertImpl extends EnumerableAssertImpl<boolean[], BooleanArrayAssert>
    implements BooleanArrayAssert {
  @Override
  AbstractBooleanArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
