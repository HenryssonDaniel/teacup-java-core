package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MapAssertTest {
  private static final Map<Object, Object> ACTUAL = new HashMap<>(0);
  private static final String FUN = "fun";
  private static final String IS = "is";
  private static final String NEVER = "never";
  private static final String TEST = "test";

  @Test
  void verify() {
    Map<Object, Object> map = new HashMap<>(3);
    map.put(TEST, 1);
    map.put(IS, 2);
    map.put(FUN, 3);

    Collection<String> strings = new ArrayList<>(3);
    strings.add(TEST);
    strings.add(IS);
    strings.add(FUN);

    Factory.createMapAssert()
        .contains(Map.entry(TEST, 1))
        .containsAllEntriesOf(map)
        .containsAnyOf(Map.entry(TEST, 1), Map.entry(TEST, 2))
        .containsEntry(TEST, 1)
        .containsExactly(Map.entry(TEST, 1), Map.entry(IS, 2), Map.entry(FUN, 3))
        .containsKey(TEST)
        .containsKeys(TEST, IS, FUN)
        .containsOnly(Map.entry(TEST, 1), Map.entry(IS, 2), Map.entry(FUN, 3))
        .containsOnlyKeys(TEST, IS, FUN)
        .containsValue(1)
        .containsValues(1, 2, 3)
        .doesNotContain(Map.entry(TEST, 2))
        .doesNotContainEntry(TEST, 2)
        .doesNotContainKey(NEVER)
        .doesNotContainKeys(NEVER, "always")
        .doesNotContainValue(4)
        .doesNotHaveSameClassAs(Integer.class)
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(new int[] {1, 2, 3})
        .hasSameSizeAs(map)
        .hasSameSizeAs(strings)
        .hasSize(3)
        .isEqualTo(map)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(map)
        .verify(map);

    Factory.createMapAssert().isEmpty().isNullOrEmpty().verify(Collections.emptyMap());
  }
}
