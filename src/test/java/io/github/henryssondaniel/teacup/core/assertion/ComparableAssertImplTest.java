package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class ComparableAssertImplTest {
  private final ComparableAssert<Integer, ?> comparableAssert = new ComparableAssertImpl<>();

  @Test
  void isGreaterThan() {
    comparableAssert.isGreaterThan(1).verify(2);
  }

  @Test
  void isGreaterThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> comparableAssert.isGreaterThan(2).verify(1));
  }

  @Test
  void isGreaterThanOrEqualTo() {
    comparableAssert.isGreaterThanOrEqualTo(1).verify(1);
  }

  @Test
  void isGreaterThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> comparableAssert.isGreaterThanOrEqualTo(2).verify(1));
  }

  @Test
  void isLessThan() {
    comparableAssert.isLessThan(2).verify(1);
  }

  @Test
  void isLessThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> comparableAssert.isLessThan(1).verify(2));
  }

  @Test
  void isLessThanOrEqualTo() {
    comparableAssert.isLessThanOrEqualTo(1).verify(1);
  }

  @Test
  void isLessThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> comparableAssert.isLessThanOrEqualTo(1).verify(2));
  }
}
