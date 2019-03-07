package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MapAssertImplTest {
  private static final Map<String, Integer> MAP_ORDER_ASC = new HashMap<>(2);
  private static final Map<String, Integer> MAP_ORDER_DESC = new HashMap<>(2);

  static {
    MAP_ORDER_ASC.put("a", 1);
    MAP_ORDER_ASC.put("b", 2);

    MAP_ORDER_DESC.put("b", 2);
    MAP_ORDER_DESC.put("a", 1);
  }

  private final MapAssert<String, Integer, ?> mapAssert = new MapAssertImpl<>();

  @Test
  void contains() {
    mapAssert.contains(new SimpleEntry<>("a", 1)).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsAllEntriesOf() {
    mapAssert.containsAllEntriesOf(MAP_ORDER_DESC).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsAllEntriesOfFail() {
    Map<String, Integer> map = new HashMap<>(2);
    map.put("a", 1);
    map.put("b", 1);

    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsAllEntriesOf(map).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsAnyOf() {
    mapAssert
        .containsAnyOf(new SimpleEntry<>("a", 1), new SimpleEntry<>("a", 2))
        .verify(MAP_ORDER_ASC);
  }

  @Test
  void containsAnyOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsAnyOf(new SimpleEntry<>("b", 1)).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsEntry() {
    mapAssert.containsEntry("a", 1).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsEntryFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsEntry("a", 2).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsExactly() {
    mapAssert
        .containsExactly(new SimpleEntry<>("a", 1), new SimpleEntry<>("b", 2))
        .verify(MAP_ORDER_ASC);
  }

  @Test
  void containsExactlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> mapAssert.containsExactly(new SimpleEntry<>("a", 1)).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.contains(new SimpleEntry<>("a", 2)).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsKey() {
    mapAssert.containsKey("a").verify(MAP_ORDER_ASC);
  }

  @Test
  void containsKeyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsKey("c").verify(MAP_ORDER_ASC));
  }

  @Test
  void containsKeys() {
    mapAssert.containsKeys("a", "b").verify(MAP_ORDER_ASC);
  }

  @Test
  void containsKeysFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsKeys("a", "c").verify(MAP_ORDER_ASC));
  }

  @Test
  void containsOnly() {
    mapAssert
        .containsOnly(new SimpleEntry<>("b", 2), new SimpleEntry<>("a", 1))
        .verify(MAP_ORDER_ASC);
  }

  @Test
  void containsOnlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsOnly(new SimpleEntry<>("a", 1)).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsOnlyKeys() {
    mapAssert.containsOnlyKeys("b", "a").verify(MAP_ORDER_ASC);
  }

  @Test
  void containsOnlyKeysFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsOnlyKeys("a", "c").verify(MAP_ORDER_ASC));
  }

  @Test
  void containsValue() {
    mapAssert.containsValue(1).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsValueFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsValue(3).verify(MAP_ORDER_ASC));
  }

  @Test
  void containsValues() {
    mapAssert.containsValues(1, 2).verify(MAP_ORDER_ASC);
  }

  @Test
  void containsValuesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.containsValues(1, 3).verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContain() {
    mapAssert.doesNotContain(new SimpleEntry<>("a", 2)).verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainEntry() {
    mapAssert.doesNotContainEntry("a", 2).verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainEntryFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.doesNotContainEntry("a", 1).verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> mapAssert.doesNotContain(new SimpleEntry<>("a", 1)).verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainKey() {
    mapAssert.doesNotContainKey("c").verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainKeyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.doesNotContainKey("a").verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainKeys() {
    mapAssert.doesNotContainKeys("c", "d").verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainKeysFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.doesNotContainKeys("a", "c").verify(MAP_ORDER_ASC));
  }

  @Test
  void doesNotContainValue() {
    mapAssert.doesNotContainValue(3).verify(MAP_ORDER_ASC);
  }

  @Test
  void doesNotContainValueFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> mapAssert.doesNotContainValue(1).verify(MAP_ORDER_ASC));
  }

  @Test
  void hasSameSizeAs() {
    mapAssert.hasSameSizeAs(MAP_ORDER_DESC).verify(MAP_ORDER_ASC);
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> mapAssert.hasSameSizeAs(Collections.singletonMap("a", 1)).verify(MAP_ORDER_ASC));
  }
}
