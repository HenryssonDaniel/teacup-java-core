package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class ObjectArrayAssertTest {
  private static final Object[] ACTUAL = new Object[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    Object[] objects = {1L, 2L};

    Factory.createObjectArrayAssert()
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

    Factory.createObjectArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
