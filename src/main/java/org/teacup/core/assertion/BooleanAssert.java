package org.teacup.core.assertion;

/**
 * Boolean assertions.
 *
 * @since 1.0
 */
public interface BooleanAssert extends ObjectAssert<Boolean, BooleanAssert> {
  /**
   * Verifies that the boolean is false.
   *
   * @return the boolean assert
   */
  BooleanAssert isFalse();

  /**
   * Verifies that the boolean is true.
   *
   * @return the boolean assert
   */
  BooleanAssert isTrue();
}
