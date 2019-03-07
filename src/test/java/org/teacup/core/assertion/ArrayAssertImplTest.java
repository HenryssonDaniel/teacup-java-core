package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.AbstractArrayAssert;
import org.junit.jupiter.api.Test;

class ArrayAssertImplTest {
  private static final int[] ACTUAL = {1, 2};
  private static final int[] ACTUAL_EMPTY = {};

  private final ArrayAssert<int[], TestArrayAssert> arrayAssert = new TestArrayAssert();

  @Test
  void hasSameSizeAs() {
    Collection<Long> list = new ArrayList<>(2);
    list.add(0L);
    list.add(1L);

    arrayAssert.hasSameSizeAs(list).verify(ACTUAL);
  }

  @Test
  void hasSameSizeAsArray() {
    arrayAssert.hasSameSizeAs(new long[] {0L, 1L}).verify(ACTUAL);
  }

  @Test
  void hasSameSizeAsArrayFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> arrayAssert.hasSameSizeAs(new long[] {0L}).verify(ACTUAL));
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> arrayAssert.hasSameSizeAs(Collections.singletonList(1)).verify(ACTUAL));
  }

  @Test
  void hasSize() {
    arrayAssert.hasSize(2).verify(ACTUAL);
  }

  @Test
  void hasSizeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> arrayAssert.hasSize(1).verify(ACTUAL));
  }

  @Test
  void isEmpty() {
    arrayAssert.isEmpty().verify(ACTUAL_EMPTY);
  }

  @Test
  void isEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> arrayAssert.isEmpty().verify(ACTUAL));
  }

  @Test
  void isNotEmpty() {
    arrayAssert.isNotEmpty().verify(ACTUAL);
  }

  @Test
  void isNotEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> arrayAssert.isNotEmpty().verify(ACTUAL_EMPTY));
  }

  @Test
  void isNullOrEmpty() {
    arrayAssert.isNullOrEmpty().verify(null);
  }

  @Test
  void isNullOrEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> arrayAssert.isNullOrEmpty().verify(ACTUAL));
  }

  private static final class TestArrayAssert extends ArrayAssertImpl<int[], TestArrayAssert> {
    @Override
    AbstractArrayAssert<?, int[], ?> getAssert() {
      return assertThat(getActual());
    }
  }
}
