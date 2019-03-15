package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractFloatArrayAssert;
import org.junit.jupiter.api.Test;

class FloatArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new FloatArrayAssertImpl<>().getAssert())
        .isInstanceOf(AbstractFloatArrayAssert.class);
  }
}
