package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createContainer() {
    assertThat(Factory.createContainer(Collections.emptyList(), Collections.emptyList(), null))
        .isExactlyInstanceOf(ContainerImpl.class);
  }

  @Test
  void createExecutable() {
    assertThat(
            Factory.createExecutable(Collections.emptyList(), Collections.emptyList(), null, null))
        .isExactlyInstanceOf(ExecutableImpl.class);
  }

  @Test
  void createResult() {
    assertThat(Factory.createResult(null, null)).isExactlyInstanceOf(ResultImpl.class);
  }

  @Test
  void createRoot() {
    assertThat(Factory.createRoot(Collections.emptyList(), Collections.emptyList()))
        .isExactlyInstanceOf(RootImpl.class);
  }
}
