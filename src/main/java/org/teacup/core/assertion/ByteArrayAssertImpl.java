package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractByteArrayAssert;

class ByteArrayAssertImpl extends ArrayAssertImpl<byte[], ByteArrayAssert>
    implements ByteArrayAssert {
  @Override
  AbstractByteArrayAssert<?> getAssert() {
    return assertThat(getActual());
  }
}
