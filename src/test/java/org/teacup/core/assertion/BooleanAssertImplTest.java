package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class BooleanAssertImplTest {
  private final BooleanAssert<?> booleanAssert = new BooleanAssertImpl<>();

  @Test
  void isFalse() {
    booleanAssert.isFalse().verify(false);
  }

  @Test
  void isFalseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> booleanAssert.isFalse().verify(true));
  }

  @Test
  void isTrue() {
    booleanAssert.isTrue().verify(true);
  }

  @Test
  void isTrueFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> booleanAssert.isTrue().verify(false));
  }
}
