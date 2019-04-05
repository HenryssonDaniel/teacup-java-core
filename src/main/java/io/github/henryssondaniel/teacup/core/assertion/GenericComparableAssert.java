package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic comparable assertions.
 *
 * @param <T>the comparable type
 * @param <U> the generic comparable assert type
 * @since 1.0
 */
public interface GenericComparableAssert<
        T extends Comparable<? super T>, U extends GenericComparableAssert<T, U>>
    extends GenericObjectAssert<T, U> {
  /**
   * Verifies that the comparable is greater than the value.
   *
   * @param value the value
   * @return the comparable assert
   * @since 1.0
   */
  U isGreaterThan(T value);

  /**
   * Verifies that the comparable is greater than, or equal to, the value.
   *
   * @param value the value
   * @return the comparable assert
   * @since 1.0
   */
  U isGreaterThanOrEqualTo(T value);

  /**
   * Verifies that the comparable is less than the value.
   *
   * @param value the value
   * @return the comparable assert
   * @since 1.0
   */
  U isLessThan(T value);

  /**
   * Verifies that the comparable is less than, or equal to, the value.
   *
   * @param value the value
   * @return the comparable assert
   * @since 1.0
   */
  U isLessThanOrEqualTo(T value);
}
