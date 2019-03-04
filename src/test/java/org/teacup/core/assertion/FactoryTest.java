package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createCharSequenceAssert() {
    assertThat(Factory.createCharSequenceAssert())
        .isExactlyInstanceOf(CharSequenceAssertImpl.class);
  }

  @Test
  void createComparableAssert() {
    assertThat(Factory.createComparableAssert()).isExactlyInstanceOf(ComparableAssertImpl.class);
  }

  @Test
  void createIntegerAssert() {
    assertThat(Factory.createIntegerAssert()).isExactlyInstanceOf(IntegerAssertImpl.class);
  }

  @Test
  void createIterableAssert() {
    assertThat(Factory.createIterableAssert()).isExactlyInstanceOf(IterableAssertImpl.class);
  }

  @Test
  void createListAssert() {
    assertThat(Factory.createListAssert()).isExactlyInstanceOf(ListAssertImpl.class);
  }

  @Test
  void createMapAssert() {
    assertThat(Factory.createMapAssert()).isExactlyInstanceOf(MapAssertImpl.class);
  }

  @Test
  void createObjectAssert() {
    assertThat(Factory.createObjectAssert()).isExactlyInstanceOf(ObjectAssertImpl.class);
  }

  @Test
  void createStringAssert() {
    assertThat(Factory.createStringAssert()).isExactlyInstanceOf(StringAssertImpl.class);
  }
}
