package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createReporter() {
    assertThat(Factory.createReporter()).isExactlyInstanceOf(ReporterImpl.class);
  }

  @Test
  void createTestCase() {
    assertThat(Factory.createTestCase(null, null)).isExactlyInstanceOf(TestCaseImpl.class);
  }

  @Test
  void createTestSuite() {
    assertThat(Factory.createTestSuite(null, Collections.emptySet()))
        .isExactlyInstanceOf(TestSuiteImpl.class);
  }
}
