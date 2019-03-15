package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractCharArrayAssert;
import org.junit.jupiter.api.Test;

class CharArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new CharArrayAssertImpl<>().getAssert()).isInstanceOf(AbstractCharArrayAssert.class);
  }
}
