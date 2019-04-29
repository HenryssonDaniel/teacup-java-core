package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class DataImplTest {
  private static final String NAME = "name";
  private static final Type TYPE = Type.CASE;

  private final Path path = Path.of(NAME);
  private final Data data = new DataImpl(NAME, path, TYPE);

  @Test
  void getName() {
    assertThat(data.getName()).isEqualTo(NAME);
  }

  @Test
  void getTestCases() {
    assertThat(data.getPath()).isSameAs(path);
  }

  @Test
  void getTimeFinished() {
    assertThat(data.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(data.getTimeStarted()).isZero();
  }

  @Test
  void getType() {
    assertThat(data.getType()).isSameAs(TYPE);
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
