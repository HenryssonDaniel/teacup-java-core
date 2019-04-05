package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GenericObjectArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractObjectArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractObjectArrayAssert.class);
  }

  private interface TestGenericObjectArrayAssert
      extends GenericObjectArrayAssert<Object, TestGenericObjectArrayAssert> {}

  private static final class TestAbstractObjectArrayAssert
      extends AbstractObjectArrayAssert<Object, TestGenericObjectArrayAssert>
      implements TestGenericObjectArrayAssert {}
}
