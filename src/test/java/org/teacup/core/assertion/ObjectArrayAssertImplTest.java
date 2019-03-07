package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractObjectArrayAssert;
import org.junit.jupiter.api.Test;

class ObjectArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new ObjectArrayAssertImpl<String>().getAssert())
        .isInstanceOf(AbstractObjectArrayAssert.class);
  }
}
