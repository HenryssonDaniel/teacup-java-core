package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class TestCaseImplTest {
  private static final String NAME = "name";

  private final Path path = Path.of(NAME);
  private final TestCase testCase = new TestCaseImpl(NAME, path);

  @Test
  void getName() {
    assertThat(testCase.getName()).isEqualTo(NAME);
  }

  @Test
  void getTestCases() {
    assertThat(testCase.getPath()).isSameAs(path);
  }

  @Test
  void getTimeFinished() {
    assertThat(testCase.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(testCase.getTimeStarted()).isZero();
  }

  @Test
  void setAndGetTimeFinished() {
    var timeFinished = 1L;
    testCase.setTimeFinished(timeFinished);
    assertThat(testCase.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 1L;
    testCase.setTimeStarted(timeStarted);
    assertThat(testCase.getTimeStarted()).isSameAs(timeStarted);
  }
}
