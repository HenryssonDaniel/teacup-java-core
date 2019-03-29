package io.github.henryssondaniel.teacup.core.assertion;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Map assertions.
 *
 * @param <T> the key type
 * @param <U> the value type
 * @param <V> the map assertion type
 * @since 1.0
 */
public interface MapAssert<T, U, V extends MapAssert<T, U, V>>
    extends EnumerableAssert<Map<T, U>, V> {
  /**
   * Verifies that the map contains the given entries, in any order.
   *
   * @param entries the entries
   * @return the map assert
   */
  V contains(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map contains all the elements of the given map.
   *
   * @param map the map
   * @return the map assert
   */
  V containsAllEntriesOf(Map<? extends T, ? extends U> map);

  /**
   * Verifies that the map contains any of the given entries.
   *
   * @param entries the entries
   * @return the map assert
   */
  V containsAnyOf(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map contains the given key and value.
   *
   * @param key the key
   * @param value the value
   * @return the map assert
   */
  V containsEntry(T key, U value);

  /**
   * Verifies that the map contains exactly the given entries.
   *
   * @param entries the entries
   * @return the map assert
   */
  V containsExactly(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map contains the given key.
   *
   * @param key the key
   * @return the map assert
   */
  V containsKey(T key);

  /**
   * Verifies that the map contains the given keys.
   *
   * @param keys the keys
   * @return the map assert
   */
  V containsKeys(T... keys);

  /**
   * Verifies that the map only contains the given entries.
   *
   * @param entries the entries
   * @return the map assert
   */
  V containsOnly(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map only contains the given keys.
   *
   * @param keys the keys
   * @return the map assert
   */
  V containsOnlyKeys(T... keys);

  /**
   * Verifies that the map contains the given value.
   *
   * @param value the value
   * @return the map assert
   */
  V containsValue(U value);

  /**
   * Verifies that the map contains the given values.
   *
   * @param values the values
   * @return the map assert
   */
  V containsValues(U... values);

  /**
   * Verifies that the map does not contain the given entries.
   *
   * @param entries the entries
   * @return the map assert
   */
  V doesNotContain(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map does not contain the given key and value.
   *
   * @param key the key
   * @param value the value
   * @return the map assert
   */
  V doesNotContainEntry(T key, U value);

  /**
   * Verifies that the map contains the given key.
   *
   * @param key the key
   * @return the map assert
   */
  V doesNotContainKey(T key);

  /**
   * Verifies that the map contains the given keys.
   *
   * @param keys the keys
   * @return the map assert
   */
  V doesNotContainKeys(T... keys);

  /**
   * Verifies that the map contains the given value.
   *
   * @param value the value
   * @return the map assert
   */
  V doesNotContainValue(U value);

  /**
   * Verifies that the map has the same size as the given map.
   *
   * @param map the map
   * @return the map assert
   */
  V hasSameSizeAs(Map<?, ?> map);
}