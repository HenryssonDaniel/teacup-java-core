package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class LongArrayAssertTest {
  private static final long[] ACTUAL = new long[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    long[] longs = {1L, 2L};

    Factory.createLongArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(longs)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(longs)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(longs)
        .verify(longs);

    Factory.createLongArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
