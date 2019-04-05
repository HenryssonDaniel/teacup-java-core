package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractBooleanArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractBooleanArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractBooleanArrayAssert.class);
  }

  private interface TestGenericBooleanArrayAssert
      extends GenericBooleanArrayAssert<TestGenericBooleanArrayAssert> {}

  private static final class TestAbstractBooleanArrayAssert
      extends AbstractBooleanArrayAssert<TestGenericBooleanArrayAssert>
      implements TestGenericBooleanArrayAssert {}
}
