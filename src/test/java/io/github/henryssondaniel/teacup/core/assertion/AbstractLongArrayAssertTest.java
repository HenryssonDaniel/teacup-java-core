package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractLongArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractLongArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractLongArrayAssert.class);
  }

  private interface TestGenericLongArrayAssert
      extends GenericLongArrayAssert<TestGenericLongArrayAssert> {}

  private static final class TestAbstractLongArrayAssert
      extends AbstractLongArrayAssert<TestGenericLongArrayAssert>
      implements TestGenericLongArrayAssert {}
}
