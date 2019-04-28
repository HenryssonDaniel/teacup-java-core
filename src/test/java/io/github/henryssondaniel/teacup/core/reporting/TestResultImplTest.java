package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TestResultImplTest {
  private static final TestStatus TEST_STATUS = TestStatus.SUCCESSFUL;

  private final Throwable throwable = new Throwable("test");
  private final TestResult testResult = new TestResultImpl(TEST_STATUS, throwable);

  @Test
  void getTestStatus() {
    assertThat(testResult.getTestStatus()).isSameAs(TEST_STATUS);
  }

  @Test
  void getThrowable() {
    assertThat(testResult.getThrowable()).containsSame(throwable);
  }
}
