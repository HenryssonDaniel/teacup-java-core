package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class StringAssertImplTest {
  private static final String GREATER = "b";
  private static final String LESS = "a";

  private final StringAssert<?> stringAssert = new StringAssertImpl<>();

  @Test
  void isGreaterThan() {
    stringAssert.isGreaterThan(LESS).verify(GREATER);
  }

  @Test
  void isGreaterThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> stringAssert.isGreaterThan(GREATER).verify(LESS));
  }

  @Test
  void isGreaterThanOrEqualTo() {
    stringAssert.isGreaterThanOrEqualTo(LESS).verify(LESS);
  }

  @Test
  void isGreaterThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> stringAssert.isGreaterThanOrEqualTo(GREATER).verify(LESS));
  }

  @Test
  void isLessThan() {
    stringAssert.isLessThan(GREATER).verify(LESS);
  }

  @Test
  void isLessThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> stringAssert.isLessThan(LESS).verify(GREATER));
  }

  @Test
  void isLessThanOrEqualTo() {
    stringAssert.isLessThanOrEqualTo(LESS).verify(LESS);
  }

  @Test
  void isLessThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> stringAssert.isLessThanOrEqualTo(LESS).verify(GREATER));
  }
}
