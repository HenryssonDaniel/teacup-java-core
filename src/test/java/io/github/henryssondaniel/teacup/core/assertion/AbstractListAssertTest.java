package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class AbstractListAssertTest {
  private final TestGenericListAssert testGenericListAssert = new TestAbstractListAssert();

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

  private interface TestGenericListAssert
      extends GenericListAssert<Integer, List<Integer>, TestGenericListAssert> {}

  private static final class TestAbstractListAssert
      extends AbstractListAssert<Integer, List<Integer>, TestGenericListAssert>
      implements TestGenericListAssert {}
}
