package org.teacup.core.assertion;

/**
 * Boolean assertions.
 *
 * @param <T> the boolean assert type
 * @since 1.0
 */
public interface BooleanAssert<T extends BooleanAssert<T>> extends ObjectAssert<Boolean, T> {
  /**
   * Verifies that the boolean is false.
   *
   * @return the boolean assert
   */
  T isFalse();

  /**
   * Verifies that the boolean is true.
   *
   * @return the boolean assert
   */
  T isTrue();
}
