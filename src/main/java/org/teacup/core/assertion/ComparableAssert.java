package org.teacup.core.assertion;

/**
 * Comparable assertions.
 *
 * @param <T>the comparable type
 * @param <U> the comparable assert type
 * @since 1.0
 */
public interface ComparableAssert<T extends Comparable<? super T>, U extends ComparableAssert<T, U>>
    extends ObjectAssert<T, U> {
  /**
   * Verifies that the comparable is greater than the value.
   *
   * @param value the value
   * @return the comparable assert
   */
  U isGreaterThan(T value);

  /**
   * Verifies that the comparable is greater than, or equal to, the value.
   *
   * @param value the value
   * @return the comparable assert
   */
  U isGreaterThanOrEqualTo(T value);

  /**
   * Verifies that the comparable is less than the value.
   *
   * @param value the value
   * @return the comparable assert
   */
  U isLessThan(T value);

  /**
   * Verifies that the comparable is less than, or equal to, the value.
   *
   * @param value the value
   * @return the comparable assert
   */
  U isLessThanOrEqualTo(T value);
}
