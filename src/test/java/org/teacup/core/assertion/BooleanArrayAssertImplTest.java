package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractBooleanArrayAssert;
import org.junit.jupiter.api.Test;

class BooleanArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new BooleanArrayAssertImpl().getAssert())
        .isInstanceOf(AbstractBooleanArrayAssert.class);
  }
}
