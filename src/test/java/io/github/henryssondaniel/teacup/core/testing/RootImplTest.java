package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class RootImplTest {
  private final Collection<? extends Container> containers = Collections.emptySet();
  private final Collection<? extends Executable> executables = Collections.emptySet();
  private final Root root = new RootImpl(containers, executables);

  @Test
  void getCases() {
    assertThat(root.getExecutables()).isEqualTo(executables);
  }

  @Test
  void getSuites() {
    assertThat(root.getContainers()).isEqualTo(containers);
  }

  @Test
  void getTimeFinished() {
    assertThat(root.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(root.getTimeStarted()).isZero();
  }

  @Test
  void setAndGetTimeFinished() {
    var timeFinished = 1L;
    root.setTimeFinished(timeFinished);
    assertThat(root.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 1L;
    root.setTimeStarted(timeStarted);
    assertThat(root.getTimeStarted()).isSameAs(timeStarted);
  }
}
