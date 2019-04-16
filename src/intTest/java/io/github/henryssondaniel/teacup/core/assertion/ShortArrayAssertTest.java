package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class ShortArrayAssertTest {
  private static final short[] ACTUAL = new short[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    short[] objects = {(short) 1, (short) 2};

    Factory.createShortArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(objects)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(objects)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(objects)
        .verify(objects);

    Factory.createShortArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
