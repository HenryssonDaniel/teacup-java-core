package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class GenericObjectAssertTest {
  private static final String VALUE = "b";
  private final TestGenericObjectAssert testGenericObjectAssert = new TestAbstractObjectAssert();

  @Test
  void doesNotHaveSameClassAs() {
    testGenericObjectAssert.doesNotHaveSameClassAs(1).verify(VALUE);
  }

  @Test
  void doesNotHaveSameClassAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericObjectAssert.doesNotHaveSameClassAs("").verify(VALUE));
  }

  @Test
  void hasSameClassAs() {
    testGenericObjectAssert.hasSameClassAs("").verify(VALUE);
  }

  @Test
  void hasSameClassAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericObjectAssert.hasSameClassAs(1).verify(VALUE));
  }

  @Test
  void isEqualTo() {
    testGenericObjectAssert.isEqualTo(VALUE).verify(VALUE);
  }

  @Test
  void isEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericObjectAssert.isEqualTo(1).verify(VALUE));
  }

  @Test
  void isNotEqualTo() {
    testGenericObjectAssert.isNotEqualTo(1).verify(VALUE);
  }

  @Test
  void isNotEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericObjectAssert.isNotEqualTo(VALUE).verify(VALUE));
  }

  @Test
  void isNotSameAs() {
    testGenericObjectAssert.isNotSameAs(1).verify(VALUE);
  }

  @Test
  void isNotSameAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericObjectAssert.isNotSameAs(VALUE).verify(VALUE));
  }

  @Test
  void isSameAs() {
    testGenericObjectAssert.isSameAs(VALUE).verify(VALUE);
  }

  @Test
  void isSameAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericObjectAssert.isSameAs(1).verify(VALUE));
  }

  private interface TestGenericObjectAssert
      extends GenericObjectAssert<String, TestGenericObjectAssert> {}

  private static final class TestAbstractObjectAssert
      extends AbstractObjectAssert<String, TestGenericObjectAssert>
      implements TestGenericObjectAssert {}
}
