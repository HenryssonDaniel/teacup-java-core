package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GenericShortArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractShortArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractShortArrayAssert.class);
  }

  private interface TestGenericShortArrayAssert
      extends GenericShortArrayAssert<TestGenericShortArrayAssert> {}

  private static final class TestAbstractShortArrayAssert
      extends AbstractShortArrayAssert<TestGenericShortArrayAssert>
      implements TestGenericShortArrayAssert {}
}
