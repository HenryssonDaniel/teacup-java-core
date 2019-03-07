package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractCharArrayAssert;

class CharArrayAssertImpl extends ArrayAssertImpl<char[], CharArrayAssert>
    implements CharArrayAssert {
  @Override
  AbstractCharArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
