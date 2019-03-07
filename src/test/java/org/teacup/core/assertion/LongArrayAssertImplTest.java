package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractLongArrayAssert;
import org.junit.jupiter.api.Test;

class LongArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new LongArrayAssertImpl().getAssert()).isInstanceOf(AbstractLongArrayAssert.class);
  }
}
