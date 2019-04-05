package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractDoubleArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractDoubleArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractDoubleArrayAssert.class);
  }

  private interface TestGenericDoubleArrayAssert
      extends GenericDoubleArrayAssert<TestGenericDoubleArrayAssert> {}

  private static final class TestAbstractDoubleArrayAssert
      extends AbstractDoubleArrayAssert<TestGenericDoubleArrayAssert>
      implements TestGenericDoubleArrayAssert {}
}
