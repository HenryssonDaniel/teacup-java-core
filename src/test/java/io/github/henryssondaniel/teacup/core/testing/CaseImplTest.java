package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class CaseImplTest {
  private static final String NAME = "name";

  private final Path path = Path.of(NAME);
  private final Case testCase = new CaseImpl(NAME, path);

  @Test
  void getName() {
    assertThat(testCase.getName()).isEqualTo(NAME);
  }

  @Test
  void getPath() {
    assertThat(testCase.getPath()).isSameAs(path);
  }
}
