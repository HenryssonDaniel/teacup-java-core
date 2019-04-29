package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExecutableImplTest {
  private final Executable executable = new ExecutableImpl();

  @Test
  void getTimeFinished() {
    assertThat(executable.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(executable.getTimeStarted()).isZero();
  }

  @Test
  void setAndGetTimeFinished() {
    var timeFinished = 1L;
    executable.setTimeFinished(timeFinished);
    assertThat(executable.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 1L;
    executable.setTimeStarted(timeStarted);
    assertThat(executable.getTimeStarted()).isSameAs(timeStarted);
  }
}
