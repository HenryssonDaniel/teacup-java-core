package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class BooleanArrayAssertTest {
  private static final boolean[] ACTUAL = new boolean[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    boolean[] booleans = {true, false};

    Factory.createBooleanArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(booleans)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(booleans)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(booleans)
        .verify(booleans);

    Factory.createBooleanArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
