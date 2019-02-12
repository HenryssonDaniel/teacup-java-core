package org.teacup.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UtilsTest {
  private static final String OBJECT = "object";

  private final Object object = new Object();

  @Test
  void getField() throws IllegalAccessException, NoSuchFieldException {
    assertThat(Utils.getField(UtilsTest.class, this, OBJECT)).isSameAs(object);
  }

  @Test
  void setAndGetField() throws IllegalAccessException, NoSuchFieldException {
    var differentObject = "";
    Utils.setField(UtilsTest.class, this, OBJECT, differentObject);
    assertThat(Utils.getField(UtilsTest.class, this, OBJECT)).isSameAs(differentObject);
  }
}
