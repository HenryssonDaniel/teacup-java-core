package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class CharArrayAssertTest {
  private static final char[] ACTUAL = new char[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    char[] chars = {'a', 'b'};

    Factory.createCharArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(chars)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(chars)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(chars)
        .verify(chars);

    Factory.createCharArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
