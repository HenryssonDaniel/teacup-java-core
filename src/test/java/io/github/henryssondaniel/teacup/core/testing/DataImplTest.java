package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DataImplTest {
  private final Data data = new DataImpl();

  @Test
  void getTimeFinished() {
    assertThat(data.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(data.getTimeStarted()).isZero();
  }

  @Test
  void setAndGetTimeFinished() {
    var timeFinished = 1L;
    data.setTimeFinished(timeFinished);
    assertThat(data.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 1L;
    data.setTimeStarted(timeStarted);
    assertThat(data.getTimeStarted()).isSameAs(timeStarted);
  }
}
