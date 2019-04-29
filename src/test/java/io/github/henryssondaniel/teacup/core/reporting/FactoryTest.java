package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void getReporter() {
    assertThat(Factory.getReporter()).isExactlyInstanceOf(ReporterImpl.class);
  }
}
