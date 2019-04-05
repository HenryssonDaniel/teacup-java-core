package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractIntArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractIntArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractIntArrayAssert.class);
  }

  private interface TestGenericIntArrayAssert
      extends GenericIntArrayAssert<TestGenericIntArrayAssert> {}

  private static final class TestAbstractIntArrayAssert
      extends AbstractIntArrayAssert<TestGenericIntArrayAssert>
      implements TestGenericIntArrayAssert {}
}
