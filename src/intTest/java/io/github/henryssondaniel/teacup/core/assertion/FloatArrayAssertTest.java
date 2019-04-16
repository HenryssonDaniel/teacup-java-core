package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class FloatArrayAssertTest {
  private static final float[] ACTUAL = new float[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    float[] floats = {1.0f, 0.0f};

    Factory.createFloatArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(floats)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(floats)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(floats)
        .verify(floats);

    Factory.createFloatArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
