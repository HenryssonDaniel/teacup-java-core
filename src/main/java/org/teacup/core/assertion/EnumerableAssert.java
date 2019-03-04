package org.teacup.core.assertion;

/**
 * Enumerable assertions.
 *
 * @param <T> the enumerable assert type
 * @since 1.0
 */
public interface EnumerableAssert<T extends EnumerableAssert<T>> {
  /**
   * Verifies that the enumerable has the same size as the other.
   *
   * @param other the other
   * @return the enumerable assert
   */
  T hasSameSizeAs(Iterable<?> other);

  /**
   * Verifies that the enumerable has the same size as the array.
   *
   * @param array the other
   * @return the enumerable assert
   */
  T hasSameSizeAs(Object array);

  /**
   * Verifies that the enumerable has the expected size.
   *
   * @param expected the array
   * @return the enumerable assert
   */
  T hasSize(int expected);

  /**
   * Verifies that the enumerable is empty.
   *
   * @return the enumerable assert
   */
  T isEmpty();

  /**
   * Verifies that the enumerable is not empty.
   *
   * @return the enumerable assert
   */
  T isNotEmpty();

  /**
   * Verifies that the enumerable is null or empty.
   *
   * @return the enumerable assert
   */
  T isNullOrEmpty();
}
