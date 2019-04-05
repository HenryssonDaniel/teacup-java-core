package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic boolean assertions.
 *
 * @param <T> the generic boolean assert type
 * @since 1.0
 */
public interface GenericBooleanAssert<T extends GenericBooleanAssert<T>>
    extends GenericObjectAssert<Boolean, T> {
  /**
   * Verifies that the boolean is false.
   *
   * @return the boolean assert
   * @since 1.0
   */
  T isFalse();

  /**
   * Verifies that the boolean is true.
   *
   * @return the boolean assert
   * @since 1.0
   */
  T isTrue();
}
