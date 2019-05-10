package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {
  private static final Status STATUS = Status.SUCCESSFUL;
  private final Result result = Factory.createResult(STATUS, null);

  @Test
  void getName() {
    assertThat(result.getStatus()).isSameAs(STATUS);
  }

  @Test
  void getNodes() {
    assertThat(result.getThrowable()).isEmpty();
  }
}
