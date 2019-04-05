package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractFloatArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractFloatArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractFloatArrayAssert.class);
  }

  private interface TestGenericFloatArrayAssert
      extends GenericFloatArrayAssert<TestGenericFloatArrayAssert> {}

  private static final class TestAbstractFloatArrayAssert
      extends AbstractFloatArrayAssert<TestGenericFloatArrayAssert>
      implements TestGenericFloatArrayAssert {}
}
