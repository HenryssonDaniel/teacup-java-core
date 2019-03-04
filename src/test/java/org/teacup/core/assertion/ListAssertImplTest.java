package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListAssertImplTest {
  private final ListAssert<Integer, List<Integer>, ?> listAssert = new ListAssertImpl<>();

  @Test
  void contains() {
    listAssert.contains(1, 0).verify(Collections.singletonList(1));
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> listAssert.contains(2, 0).verify(Collections.singletonList(1)));
  }

  @Test
  void doesNotContain() {
    listAssert.doesNotContain(1, 2).verify(Collections.singletonList(1));
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> listAssert.doesNotContain(1, 0).verify(Collections.singletonList(1)));
  }
}
