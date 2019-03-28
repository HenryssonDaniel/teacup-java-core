package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createBooleanArrayAssert() {
    assertThat(Factory.createBooleanArrayAssert())
        .isExactlyInstanceOf(BooleanArrayAssertImpl.class);
  }

  @Test
  void createBooleanAssert() {
    assertThat(Factory.createBooleanAssert()).isExactlyInstanceOf(BooleanAssertImpl.class);
  }

  @Test
  void createByteArrayAssert() {
    assertThat(Factory.createByteArrayAssert()).isExactlyInstanceOf(ByteArrayAssertImpl.class);
  }

  @Test
  void createCharArrayAssert() {
    assertThat(Factory.createCharArrayAssert()).isExactlyInstanceOf(CharArrayAssertImpl.class);
  }

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
  void createDoubleArrayAssert() {
    assertThat(Factory.createDoubleArrayAssert()).isExactlyInstanceOf(DoubleArrayAssertImpl.class);
  }

  @Test
  void createFloatArrayAssert() {
    assertThat(Factory.createFloatArrayAssert()).isExactlyInstanceOf(FloatArrayAssertImpl.class);
  }

  @Test
  void createIntArrayAssert() {
    assertThat(Factory.createIntArrayAssert()).isExactlyInstanceOf(IntArrayAssertImpl.class);
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
  void createLongArrayAssert() {
    assertThat(Factory.createLongArrayAssert()).isExactlyInstanceOf(LongArrayAssertImpl.class);
  }

  @Test
  void createLongAssert() {
    assertThat(Factory.createLongAssert()).isExactlyInstanceOf(LongAssertImpl.class);
  }

  @Test
  void createMapAssert() {
    assertThat(Factory.createMapAssert()).isExactlyInstanceOf(MapAssertImpl.class);
  }

  @Test
  void createObjectArrayAssert() {
    assertThat(Factory.createObjectArrayAssert()).isExactlyInstanceOf(ObjectArrayAssertImpl.class);
  }

  @Test
  void createObjectAssert() {
    assertThat(Factory.createObjectAssert()).isExactlyInstanceOf(ObjectAssertImpl.class);
  }

  @Test
  void createShortArrayAssert() {
    assertThat(Factory.createShortArrayAssert()).isExactlyInstanceOf(ShortArrayAssertImpl.class);
  }

  @Test
  void createStringAssert() {
    assertThat(Factory.createStringAssert()).isExactlyInstanceOf(StringAssertImpl.class);
  }
}
