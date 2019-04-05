package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class AbstractComparableAssertTest {
  private final TestGenericComparableAssert testGenericComparableAssert =
      new TestAbstractComparableAssert();

  @Test
  void isGreaterThan() {
    testGenericComparableAssert.isGreaterThan(1).verify(2);
  }

  @Test
  void isGreaterThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericComparableAssert.isGreaterThan(2).verify(1));
  }

  @Test
  void isGreaterThanOrEqualTo() {
    testGenericComparableAssert.isGreaterThanOrEqualTo(1).verify(1);
  }

  @Test
  void isGreaterThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericComparableAssert.isGreaterThanOrEqualTo(2).verify(1));
  }

  @Test
  void isLessThan() {
    testGenericComparableAssert.isLessThan(2).verify(1);
  }

  @Test
  void isLessThanFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericComparableAssert.isLessThan(1).verify(2));
  }

  @Test
  void isLessThanOrEqualTo() {
    testGenericComparableAssert.isLessThanOrEqualTo(1).verify(1);
  }

  @Test
  void isLessThanOrEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericComparableAssert.isLessThanOrEqualTo(1).verify(2));
  }

  private interface TestGenericComparableAssert
      extends GenericComparableAssert<Integer, TestGenericComparableAssert> {}

  private static final class TestAbstractComparableAssert
      extends AbstractComparableAssert<Integer, TestGenericComparableAssert>
      implements TestGenericComparableAssert {}
}
