package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class IntArrayAssertTest {
  private static final int[] ACTUAL = new int[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    int[] integers = {1, 2};

    Factory.createIntArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(integers)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(integers)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(integers)
        .verify(integers);

    Factory.createIntArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
