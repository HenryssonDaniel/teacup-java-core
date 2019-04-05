package io.github.henryssondaniel.teacup.core.assertion;

import java.util.List;

/**
 * Generic list assertions.
 *
 * @param <T> the type
 * @param <U> the list type
 * @param <V> the generic list assertion type
 * @since 1.0
 */
public interface GenericListAssert<
        T, U extends List<? extends T>, V extends GenericListAssert<T, U, V>>
    extends GenericIterableAssert<T, U, V> {
  /**
   * Verifies that the List contains the given value at the given index.
   *
   * @param value the value
   * @param index the index
   * @return the list assert
   * @since 1.0
   */
  V contains(T value, int index);

  /**
   * Verifies that the List does not contain the given value at the given index.
   *
   * @param value the value
   * @param index the index
   * @return the list assert
   * @since 1.0
   */
  V doesNotContain(T value, int index);
}
