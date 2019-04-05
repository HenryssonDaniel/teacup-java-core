package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class GenericStringAssertTest {
  private static final String GREATER = "b";
  private static final String LESS = "a";

  private final TestGenericStringAssert testGenericStringAssert = new TestAbstractStringAssert();

  @Test
  void isGreaterThan() {
    testGenericStringAssert.isGreaterThan(LESS).verify(GREATER);
  }

  @Test
  void isGreaterThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericStringAssert.isGreaterThan(GREATER).verify(LESS));
  }

  @Test
  void isGreaterThanOrEqualTo() {
    testGenericStringAssert.isGreaterThanOrEqualTo(LESS).verify(LESS);
  }

  @Test
  void isGreaterThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericStringAssert.isGreaterThanOrEqualTo(GREATER).verify(LESS));
  }

  @Test
  void isLessThan() {
    testGenericStringAssert.isLessThan(GREATER).verify(LESS);
  }

  @Test
  void isLessThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericStringAssert.isLessThan(LESS).verify(GREATER));
  }

  @Test
  void isLessThanOrEqualTo() {
    testGenericStringAssert.isLessThanOrEqualTo(LESS).verify(LESS);
  }

  @Test
  void isLessThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericStringAssert.isLessThanOrEqualTo(LESS).verify(GREATER));
  }

  private interface TestGenericStringAssert extends GenericStringAssert<TestGenericStringAssert> {}

  private static final class TestAbstractStringAssert
      extends AbstractStringAssert<TestGenericStringAssert> implements TestGenericStringAssert {}
}
