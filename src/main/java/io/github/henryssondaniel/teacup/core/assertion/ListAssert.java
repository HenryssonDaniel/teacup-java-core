package io.github.henryssondaniel.teacup.core.assertion;

import java.util.List;

/**
 * List assertions.
 *
 * @param <T> the type
 * @param <U> the list assertion type
 * @since 1.0
 */
public interface ListAssert<T, U extends ListAssert<T, U>>
    extends IterableAssert<T, List<? extends T>, U> {
  /**
   * Verifies that the List contains the given value at the given index.
   *
   * @param value the value
   * @param index the index
   * @return the list assert
   */
  U contains(T value, int index);

  /**
   * Verifies that the List does not contain the given value at the given index.
   *
   * @param value the value
   * @param index the index
   * @return the list assert
   */
  U doesNotContain(T value, int index);
}
