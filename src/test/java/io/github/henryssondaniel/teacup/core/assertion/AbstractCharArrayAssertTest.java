package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractCharArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractCharArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractCharArrayAssert.class);
  }

  private interface TestGenericCharArrayAssert
      extends GenericCharArrayAssert<TestGenericCharArrayAssert> {}

  private static final class TestAbstractCharArrayAssert
      extends AbstractCharArrayAssert<TestGenericCharArrayAssert>
      implements TestGenericCharArrayAssert {}
}
