package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.Test;

class EnumerableAssertImplTest {
  private static final int[] ACTUAL = {1, 2};
  private static final int[] ACTUAL_EMPTY = {};

  private final EnumerableAssert<int[], TestEnumerableAssert> enumerableAssert =
      new TestEnumerableAssertImpl();

  @Test
  void hasSameSizeAs() {
    Collection<Long> list = new ArrayList<>(2);
    list.add(0L);
    list.add(1L);

    enumerableAssert.hasSameSizeAs(list).verify(ACTUAL);
  }

  @Test
  void hasSameSizeAsArray() {
    enumerableAssert.hasSameSizeAs(new long[] {0L, 1L}).verify(ACTUAL);
  }

  @Test
  void hasSameSizeAsArrayFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> enumerableAssert.hasSameSizeAs(new long[] {0L}).verify(ACTUAL));
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> enumerableAssert.hasSameSizeAs(Collections.singletonList(1)).verify(ACTUAL));
  }

  @Test
  void hasSize() {
    enumerableAssert.hasSize(2).verify(ACTUAL);
  }

  @Test
  void hasSizeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> enumerableAssert.hasSize(1).verify(ACTUAL));
  }

  @Test
  void isEmpty() {
    enumerableAssert.isEmpty().verify(ACTUAL_EMPTY);
  }

  @Test
  void isEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> enumerableAssert.isEmpty().verify(ACTUAL));
  }

  @Test
  void isNotEmpty() {
    enumerableAssert.isNotEmpty().verify(ACTUAL);
  }

  @Test
  void isNotEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> enumerableAssert.isNotEmpty().verify(ACTUAL_EMPTY));
  }

  @Test
  void isNullOrEmpty() {
    enumerableAssert.isNullOrEmpty().verify(null);
  }

  @Test
  void isNullOrEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> enumerableAssert.isNullOrEmpty().verify(ACTUAL));
  }

  private interface TestEnumerableAssert extends EnumerableAssert<int[], TestEnumerableAssert> {}

  private static final class TestEnumerableAssertImpl
      extends EnumerableAssertImpl<int[], TestEnumerableAssert> implements TestEnumerableAssert {
    @Override
    AbstractAssert<?, int[]> getAssert() {
      return assertThat(getActual());
    }
  }
}
