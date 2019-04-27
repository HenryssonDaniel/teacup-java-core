package io.github.henryssondaniel.teacup.core.logging;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void getLogger() {
    verify();
    verify();
  }

  private static void verify() {
    assertThat(Factory.getLogger(FactoryTest.class).getHandlers()).hasSize(1);
  }
}
