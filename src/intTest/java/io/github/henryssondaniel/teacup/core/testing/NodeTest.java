package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class NodeTest {
  private static final String NAME = "name";
  private final Node node = Factory.createNode(NAME, Collections.emptyList());

  @Test
  void getName() {
    assertThat(node.getName()).isSameAs(NAME);
  }

  @Test
  void getNodes() {
    assertThat(node.getNodes()).isEmpty();
  }

  @Test
  void getTimeFinished() {
    assertThat(node.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(node.getTimeStarted()).isZero();
  }

  @Test
  void setAndGetTimeFinished() {
    var timeFinished = 0L;
    node.setTimeFinished(timeFinished);
    assertThat(node.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 0L;
    node.setTimeStarted(timeStarted);
    assertThat(node.getTimeStarted()).isSameAs(timeStarted);
  }
}
