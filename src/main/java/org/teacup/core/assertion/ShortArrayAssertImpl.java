package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractShortArrayAssert;

class ShortArrayAssertImpl extends ArrayAssertImpl<short[], ShortArrayAssert>
    implements ShortArrayAssert {
  @Override
  AbstractShortArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
