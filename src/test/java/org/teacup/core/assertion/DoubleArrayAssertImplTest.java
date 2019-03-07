package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractDoubleArrayAssert;
import org.junit.jupiter.api.Test;

class DoubleArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new DoubleArrayAssertImpl().getAssert())
        .isInstanceOf(AbstractDoubleArrayAssert.class);
  }
}
