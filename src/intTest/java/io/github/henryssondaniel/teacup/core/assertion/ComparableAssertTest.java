package io.github.henryssondaniel.teacup.core.assertion;

import org.junit.jupiter.api.Test;

class ComparableAssertTest {
  private static final long ACTUAL = 0L;

  @Test
  void verify() {
    Factory.<Long>createComparableAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .isEqualTo(1L)
        .isGreaterThan(ACTUAL)
        .isGreaterThanOrEqualTo(1L)
        .isLessThan(2L)
        .isLessThanOrEqualTo(2L)
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(1L)
        .verify(1L);
  }
}
