package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultImplTest {
  private static final Status STATUS = Status.SUCCESSFUL;

  private final Throwable throwable = new Throwable("test");
  private final Result result = new ResultImpl(STATUS, throwable);

  @Test
  void getStatus() {
    assertThat(result.getStatus()).isSameAs(STATUS);
  }

  @Test
  void getThrowable() {
    assertThat(result.getThrowable()).containsSame(throwable);
  }
}
