package org.teacup.core.assertion;

import java.util.List;

/**
 * List assertions.
 *
 * @param <T> the type
 * @param <U> the list type
 * @param <V> the list assertion type
 * @since 1.0
 */
public interface ListAssert<T, U extends List<T>, V extends ListAssert<T, U, V>>
    extends IterableAssert<T, U, V> {
  /**
   * Verifies that the List contains the given value at the given index.
   *
   * @param value the value
   * @param index the index
   * @return
   */
  V contains(T value, int index);

  /**
   * Verifies that the List does not contain the given value at the given index.
   *
   * @param value the value
   * @param index the index
   * @return
   */
  V doesNotContain(T value, int index);
}
