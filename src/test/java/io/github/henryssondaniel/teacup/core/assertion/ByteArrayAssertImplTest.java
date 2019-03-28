package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AbstractByteArrayAssert;
import org.junit.jupiter.api.Test;

class ByteArrayAssertImplTest {
  @Test
  void getAssert() {
    assertThat(new ByteArrayAssertImpl<>().getAssert()).isInstanceOf(AbstractByteArrayAssert.class);
  }
}
