package io.github.henryssondaniel.teacup.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TeacupExceptionTest {
  @Test
  void constructor() {
    var message = "test";
    assertThat(new TeacupException(message)).hasMessage(message);
  }
}
