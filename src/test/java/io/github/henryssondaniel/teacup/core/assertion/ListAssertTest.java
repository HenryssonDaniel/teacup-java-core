package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;

class ListAssertTest {
  @Test
  void isExactlyInstanceOf() {
    assertThat(new ListAssertImpl<>().getAssert()).isExactlyInstanceOf(ListAssert.class);
  }
}
