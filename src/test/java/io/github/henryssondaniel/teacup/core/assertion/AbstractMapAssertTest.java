package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AbstractMapAssertTest {
  private static final Map<String, Integer> MAP_ORDER_ASC = new HashMap<>(2);
  private static final Map<String, Integer> MAP_ORDER_DESC = new HashMap<>(2);

  static {
    MAP_ORDER_ASC.put("a", 1);
    MAP_ORDER_ASC.put("b", 2);

    MAP_ORDER_DESC.put("b", 2);
    MAP_ORDER_DESC.put("a", 1);
  }

  private final TestGenericMapAssert testGenericMapAssert = new TestAbstractMapAssert();

  @Test
  void contains() {
    testGenericMapAssert.contains(new SimpleEntry<>("a", 1)).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsAllEntriesOf() {
    testGenericMapAssert.containsAllEntriesOf(MAP_ORDER_DESC).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsAllEntriesOfFail() {
    Map<String, Integer> map = new HashMap<>(2);
    map.put("a", 1);
    map.put("b", 1);

    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsAllEntriesOf(map).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsAnyOf() {
    testGenericMapAssert
        .containsAnyOf(new SimpleEntry<>("a", 1), new SimpleEntry<>("a", 2))
        .verify(MAP_ORDER_ASC);
  }

  @Test
  void containsAnyOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericMapAssert
                    .containsAnyOf(new SimpleEntry<>("b", 1))
                    .verify(MAP_ORDER_ASC));
  }

  @Test
  void containsEntry() {
    testGenericMapAssert.containsEntry("a", 1).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsEntryFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsEntry("a", 2).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsExactly() {
    testGenericMapAssert
        .containsExactly(new SimpleEntry<>("a", 1), new SimpleEntry<>("b", 2))
        .verify(MAP_ORDER_ASC);
  }

  @Test
  void containsExactlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericMapAssert
                    .containsExactly(new SimpleEntry<>("a", 1))
                    .verify(MAP_ORDER_ASC));
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericMapAssert.contains(new SimpleEntry<>("a", 2)).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsKey() {
    testGenericMapAssert.containsKey("a").verify(MAP_ORDER_ASC);
  }

  @Test
  void containsKeyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsKey("c").verify(MAP_ORDER_ASC));
  }

  @Test
  void containsKeys() {
    testGenericMapAssert.containsKeys("a", "b").verify(MAP_ORDER_ASC);
  }

  @Test
  void containsKeysFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsKeys("a", "c").verify(MAP_ORDER_ASC));
  }

  @Test
  void containsOnly() {
    testGenericMapAssert
        .containsOnly(new SimpleEntry<>("b", 2), new SimpleEntry<>("a", 1))
        .verify(MAP_ORDER_ASC);
  }

  @Test
  void containsOnlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericMapAssert.containsOnly(new SimpleEntry<>("a", 1)).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsOnlyKeys() {
    testGenericMapAssert.containsOnlyKeys("b", "a").verify(MAP_ORDER_ASC);
  }

  @Test
  void containsOnlyKeysFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsOnlyKeys("a", "c").verify(MAP_ORDER_ASC));
  }

  @Test
  void containsValue() {
    testGenericMapAssert.containsValue(1).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsValueFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsValue(3).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsValues() {
    testGenericMapAssert.containsValues(1, 2).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsValuesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.containsValues(1, 3).verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContain() {
    testGenericMapAssert.doesNotContain(new SimpleEntry<>("a", 2)).verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainEntry() {
    testGenericMapAssert.doesNotContainEntry("a", 2).verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainEntryFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.doesNotContainEntry("a", 1).verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericMapAssert
                    .doesNotContain(new SimpleEntry<>("a", 1))
                    .verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainKey() {
    testGenericMapAssert.doesNotContainKey("c").verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainKeyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.doesNotContainKey("a").verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainKeys() {
    testGenericMapAssert.doesNotContainKeys("c", "d").verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainKeysFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.doesNotContainKeys("a", "c").verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainValue() {
    testGenericMapAssert.doesNotContainValue(3).verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainValueFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericMapAssert.doesNotContainValue(1).verify(MAP_ORDER_ASC));
  }

  @Test
  void hasSameSizeAs() {
    testGenericMapAssert.hasSameSizeAs(MAP_ORDER_DESC).verify(MAP_ORDER_ASC);
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericMapAssert
                    .hasSameSizeAs(Collections.singletonMap("a", 1))
                    .verify(MAP_ORDER_ASC));
  }

  private interface TestGenericMapAssert
      extends GenericMapAssert<String, Integer, Map<String, Integer>, TestGenericMapAssert> {}

  private static final class TestAbstractMapAssert
      extends AbstractMapAssert<String, Integer, Map<String, Integer>, TestGenericMapAssert>
      implements TestGenericMapAssert {}
}
