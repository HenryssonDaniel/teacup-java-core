package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class AbstractListAssertTest {
  private final TestGenericListAssert<Integer> testGenericListAssert =
      new TestAbstractListAssert<>();

  @Test
  void contains() {
    testGenericListAssert.contains(1, 0).verify(Collections.singletonList(1));
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericListAssert.contains(2, 0).verify(Collections.singletonList(1)));
  }

  @Test
  void doesNotContain() {
    testGenericListAssert.doesNotContain(1, 2).verify(Collections.singletonList(1));
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericListAssert.doesNotContain(1, 0).verify(Collections.singletonList(1)));
  }

  private interface TestGenericListAssert<T>
      extends GenericListAssert<T, List<? extends T>, TestGenericListAssert<T>> {}

  private static final class TestAbstractListAssert<T>
      extends AbstractListAssert<T, List<? extends T>, TestGenericListAssert<T>>
      implements TestGenericListAssert<T> {
    @Override
    org.assertj.core.api.AbstractListAssert<?, List<? extends T>, T, ?> getAssert() {
      return assertThat(getActual());
    }
  }
}
