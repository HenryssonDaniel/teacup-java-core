package io.github.henryssondaniel.teacup.core.assertion;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Generic map assertions.
 *
 * @param <T> the key type
 * @param <U> the value type
 * @param <V> the map type
 * @param <W> the generic map assertion type
 * @since 1.0
 */
public interface GenericMapAssert<T, U, V extends Map<T, U>, W extends GenericMapAssert<T, U, V, W>>
    extends EnumerableAssert<V, W> {
  /**
   * Verifies that the map contains the given entries, in any order.
   *
   * @param entries the entries
   * @return the map assert
   * @since 1.0
   */
  W contains(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map contains all the elements of the given map.
   *
   * @param map the map
   * @return the map assert
   * @since 1.0
   */
  W containsAllEntriesOf(Map<? extends T, ? extends U> map);

  /**
   * Verifies that the map contains any of the given entries.
   *
   * @param entries the entries
   * @return the map assert
   * @since 1.0
   */
  W containsAnyOf(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map contains the given key and value.
   *
   * @param key the key
   * @param value the value
   * @return the map assert
   * @since 1.0
   */
  W containsEntry(T key, U value);

  /**
   * Verifies that the map contains exactly the given entries.
   *
   * @param entries the entries
   * @return the map assert
   * @since 1.0
   */
  W containsExactly(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map contains the given key.
   *
   * @param key the key
   * @return the map assert
   * @since 1.0
   */
  W containsKey(T key);

  /**
   * Verifies that the map contains the given keys.
   *
   * @param keys the keys
   * @return the map assert
   * @since 1.0
   */
  W containsKeys(T... keys);

  /**
   * Verifies that the map only contains the given entries.
   *
   * @param entries the entries
   * @return the map assert
   * @since 1.0
   */
  W containsOnly(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map only contains the given keys.
   *
   * @param keys the keys
   * @return the map assert
   * @since 1.0
   */
  W containsOnlyKeys(T... keys);

  /**
   * Verifies that the map contains the given value.
   *
   * @param value the value
   * @return the map assert
   * @since 1.0
   */
  W containsValue(U value);

  /**
   * Verifies that the map contains the given values.
   *
   * @param values the values
   * @return the map assert
   * @since 1.0
   */
  W containsValues(U... values);

  /**
   * Verifies that the map does not contain the given entries.
   *
   * @param entries the entries
   * @return the map assert
   * @since 1.0
   */
  W doesNotContain(Entry<? extends T, ? extends U>... entries);

  /**
   * Verifies that the map does not contain the given key and value.
   *
   * @param key the key
   * @param value the value
   * @return the map assert
   * @since 1.0
   */
  W doesNotContainEntry(T key, U value);

  /**
   * Verifies that the map contains the given key.
   *
   * @param key the key
   * @return the map assert
   * @since 1.0
   */
  W doesNotContainKey(T key);

  /**
   * Verifies that the map contains the given keys.
   *
   * @param keys the keys
   * @return the map assert
   * @since 1.0
   */
  W doesNotContainKeys(T... keys);

  /**
   * Verifies that the map contains the given value.
   *
   * @param value the value
   * @return the map assert
   * @since 1.0
   */
  W doesNotContainValue(U value);

  /**
   * Verifies that the map has the same size as the given map.
   *
   * @param map the map
   * @return the map assert
   * @since 1.0
   */
  W hasSameSizeAs(Map<?, ?> map);
}
