package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractIntArrayAssert;
import org.junit.jupiter.api.Test;

class IntArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new IntArrayAssertImpl().getAssert()).isInstanceOf(AbstractIntArrayAssert.class);
  }
}
