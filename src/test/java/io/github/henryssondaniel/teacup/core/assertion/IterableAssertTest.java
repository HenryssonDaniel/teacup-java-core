package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.IterableAssert;
import org.junit.jupiter.api.Test;

class IterableAssertTest {
  @Test
  void isExactlyInstanceOf() {
    assertThat(new IterableAssertImpl<>().getAssert()).isExactlyInstanceOf(IterableAssert.class);
  }
}
