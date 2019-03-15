package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractShortArrayAssert;
import org.junit.jupiter.api.Test;

class ShortArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new ShortArrayAssertImpl<>().getAssert())
        .isInstanceOf(AbstractShortArrayAssert.class);
  }
}
