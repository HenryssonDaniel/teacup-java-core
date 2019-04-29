package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class SuiteImplTest {
  private final Collection<Case> cases = Collections.emptySet();
  private final Path path = mock(Path.class);
  private final Collection<Suite> suites = Collections.emptySet();
  private final Suite suite = new SuiteImpl(cases, path, suites);

  @Test
  void getCases() {
    assertThat(suite.getCases()).isEqualTo(cases);
  }

  @Test
  void getPath() {
    assertThat(suite.getPath()).isSameAs(path);
  }

  @Test
  void getSuites() {
    assertThat(suite.getSuites()).isEqualTo(suites);
  }
}
