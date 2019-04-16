package io.github.henryssondaniel.teacup.core.assertion;

import org.junit.jupiter.api.Test;

class BooleanAssertTest {
  private static final boolean ACTUAL = false;

  @Test
  void verify() {
    Factory.createBooleanAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .isEqualTo(true)
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(true)
        .isTrue()
        .verify(true);

    Factory.createBooleanAssert().isFalse().verify(false);
  }
}
