package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class AbstractBooleanAssertImplTest {
  private final TestGenericBooleanAssert testGenericBooleanAssert = new TestAbstractBooleanAssert();

  @Test
  void isFalse() {
    testGenericBooleanAssert.isFalse().verify(false);
  }

  @Test
  void isFalseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericBooleanAssert.isFalse().verify(true));
  }

  @Test
  void isTrue() {
    testGenericBooleanAssert.isTrue().verify(true);
  }

  @Test
  void isTrueFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericBooleanAssert.isTrue().verify(false));
  }

  private interface TestGenericBooleanAssert
      extends GenericBooleanAssert<TestGenericBooleanAssert> {}

  private static final class TestAbstractBooleanAssert
      extends AbstractBooleanAssert<TestGenericBooleanAssert> implements TestGenericBooleanAssert {}
}
