package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractIntArrayAssert;

class IntArrayAssertImpl extends ArrayAssertImpl<int[], IntArrayAssert> implements IntArrayAssert {
  @Override
  AbstractIntArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
