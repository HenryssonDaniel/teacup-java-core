package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

class ByteArrayAssertTest {
  private static final byte[] ACTUAL = new byte[0];

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(2);
    strings.add("test");
    strings.add("test");

    byte[] bytes = {(byte) 1, (byte) 2};

    Factory.createByteArrayAssert()
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(bytes)
        .hasSameSizeAs(strings)
        .hasSize(2)
        .isEqualTo(bytes)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(bytes)
        .verify(bytes);

    Factory.createByteArrayAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);
  }
}
