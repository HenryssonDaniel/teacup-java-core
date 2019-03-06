package org.teacup.core.assertion;

/**
 * Enumerable assertions.
 *
 * @param <T> the enumerable type
 * @param <U> the enumerable assert type
 * @since 1.0
 */
public interface EnumerableAssert<T, U extends EnumerableAssert<T, U>> extends ObjectAssert<T, U> {
  /**
   * Verifies that the enumerable has the same size as the other.
   *
   * @param other the other
   * @return the enumerable assert
   */
  U hasSameSizeAs(Iterable<?> other);

  /**
   * Verifies that the enumerable has the same size as the array.
   *
   * @param array the other
   * @return the enumerable assert
   */
  U hasSameSizeAs(Object array);

  /**
   * Verifies that the enumerable has the expected size.
   *
   * @param expected the array
   * @return the enumerable assert
   */
  U hasSize(int expected);

  /**
   * Verifies that the enumerable is empty.
   *
   * @return the enumerable assert
   */
  U isEmpty();

  /**
   * Verifies that the enumerable is not empty.
   *
   * @return the enumerable assert
   */
  U isNotEmpty();

  /**
   * Verifies that the enumerable is null or empty.
   *
   * @return the enumerable assert
   */
  U isNullOrEmpty();
}
