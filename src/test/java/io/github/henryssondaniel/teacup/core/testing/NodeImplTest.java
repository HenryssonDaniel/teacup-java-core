package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class NodeImplTest {
  private static final String NAME = "name";

  private final Collection<Node> nodes = Collections.emptySet();
  private final Node node = new NodeImpl(NAME, nodes);

  @Test
  void getName() {
    assertThat(node.getName()).isEqualTo(NAME);
  }

  @Test
  void getNodes() {
    assertThat(node.getNodes()).isEqualTo(nodes);
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
    var timeFinished = 1L;
    node.setTimeFinished(timeFinished);
    assertThat(node.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 1L;
    node.setTimeStarted(timeStarted);
    assertThat(node.getTimeStarted()).isSameAs(timeStarted);
  }
}
