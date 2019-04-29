package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class ContainerImplTest {
  private final Collection<? extends Case> cases = Collections.emptySet();
  private final Collection<? extends Suite> suites = Collections.emptySet();
  private final Container container = new ContainerImpl(cases, suites);

  @Test
  void getCases() {
    assertThat(container.getCases()).isEqualTo(cases);
  }

  @Test
  void getSuites() {
    assertThat(container.getSuites()).isEqualTo(suites);
  }
}
