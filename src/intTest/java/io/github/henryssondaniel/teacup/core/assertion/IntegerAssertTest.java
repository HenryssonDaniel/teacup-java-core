package io.github.henryssondaniel.teacup.core.assertion;

import org.junit.jupiter.api.Test;

class IntegerAssertTest {
  private static final int ACTUAL = 0;

  @Test
  void verify() {
    Factory.createIntegerAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .isEqualTo(1)
        .isGreaterThan(ACTUAL)
        .isGreaterThanOrEqualTo(1)
        .isLessThan(2)
        .isLessThanOrEqualTo(2)
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(1)
        .verify(1);
  }
}
