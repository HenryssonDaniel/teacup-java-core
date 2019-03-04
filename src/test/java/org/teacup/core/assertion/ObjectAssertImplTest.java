package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class ObjectAssertImplTest {
  private static final String VALUE = "b";
  private final ObjectAssert<String, ?> objectAssert = new ObjectAssertImpl<>();

  @Test
  void doesNotHaveSameClassAs() {
    objectAssert.doesNotHaveSameClassAs(1).verify(VALUE);
  }

  @Test
  void doesNotHaveSameClassAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> objectAssert.doesNotHaveSameClassAs("").verify(VALUE));
  }

  @Test
  void hasSameClassAs() {
    objectAssert.hasSameClassAs("").verify(VALUE);
  }

  @Test
  void hasSameClassAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> objectAssert.hasSameClassAs(1).verify(VALUE));
  }

  @Test
  void isEqualTo() {
    objectAssert.isEqualTo(VALUE).verify(VALUE);
  }

  @Test
  void isEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> objectAssert.isEqualTo(1).verify(VALUE));
  }

  @Test
  void isNotEqualTo() {
    objectAssert.isNotEqualTo(1).verify(VALUE);
  }

  @Test
  void isNotEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> objectAssert.isNotEqualTo(VALUE).verify(VALUE));
  }

  @Test
  void isNotSameAs() {
    objectAssert.isNotSameAs(1).verify(VALUE);
  }

  @Test
  void isNotSameAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> objectAssert.isNotSameAs(VALUE).verify(VALUE));
  }

  @Test
  void isSameAs() {
    objectAssert.isSameAs(VALUE).verify(VALUE);
  }

  @Test
  void isSameAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> objectAssert.isSameAs(1).verify(VALUE));
  }
}
