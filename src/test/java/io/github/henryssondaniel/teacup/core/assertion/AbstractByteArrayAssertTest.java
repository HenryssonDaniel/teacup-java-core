package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AbstractByteArrayAssertTest {
  @Test
  void getAssert() {
    assertThat(new TestAbstractByteArrayAssert().getAssert())
        .isInstanceOf(org.assertj.core.api.AbstractByteArrayAssert.class);
  }

  private interface TestGenericByteArrayAssert
      extends GenericByteArrayAssert<TestGenericByteArrayAssert> {}

  private static final class TestAbstractByteArrayAssert
      extends AbstractByteArrayAssert<TestGenericByteArrayAssert>
      implements TestGenericByteArrayAssert {}
}
