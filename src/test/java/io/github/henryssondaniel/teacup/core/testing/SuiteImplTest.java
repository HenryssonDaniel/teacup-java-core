package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.nio.file.Path;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class SuiteImplTest {
  @Test
  void getPath() {
    var path = mock(Path.class);
    assertThat(new SuiteImpl(Collections.emptyList(), path, Collections.emptyList()).getPath())
        .isSameAs(path);
  }
}
