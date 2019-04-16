package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class DoubleArrayAssertTest {
  private static final double[] ACTUAL = new double[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    double[] doubles = {1.0, 0.0};

    Factory.createDoubleArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(doubles)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(doubles)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(doubles)
        .verify(doubles);

    Factory.createDoubleArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
