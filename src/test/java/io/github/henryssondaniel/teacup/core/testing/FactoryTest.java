package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createNode() {
    assertThat(Factory.createNode(null, Collections.emptyList()))
        .isExactlyInstanceOf(NodeImpl.class);
  }

  @Test
  void createResult() {
    assertThat(Factory.createResult(null, null)).isExactlyInstanceOf(ResultImpl.class);
  }
}
