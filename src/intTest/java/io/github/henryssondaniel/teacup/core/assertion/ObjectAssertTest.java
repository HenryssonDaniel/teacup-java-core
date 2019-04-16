package io.github.henryssondaniel.teacup.core.assertion;

import org.junit.jupiter.api.Test;

class ObjectAssertTest {
  private static final boolean ACTUAL = false;

  @Test
  void verify() {
    Factory.createObjectAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .isEqualTo(true)
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(true)
        .verify(true);
  }
}
