package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ExecutableImplTest {
  @Test
  void getName() {
    var name = "name";
    assertThat(
            new ExecutableImpl(
                    Collections.emptyList(), Collections.emptyList(), name, Path.of(name))
                .getName())
        .isEqualTo(name);
  }
}
