package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createTestCase() {
    assertThat(Factory.createTestCase(null, null)).isExactlyInstanceOf(TestCaseImpl.class);
  }

  @Test
  void createTestResult() {
    assertThat(Factory.createTestResult(null, null)).isExactlyInstanceOf(TestResultImpl.class);
  }

  @Test
  void createTestSuite() {
    assertThat(Factory.createTestSuite(null, Collections.emptySet()))
        .isExactlyInstanceOf(TestSuiteImpl.class);
  }

  @Test
  void getReporter() {
    assertThat(Factory.getReporter()).isExactlyInstanceOf(ReporterImpl.class);
  }
}
