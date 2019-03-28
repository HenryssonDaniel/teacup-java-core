package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Object assertions.
 *
 * @param <T> the type
 * @param <U> the object assert type
 */
public interface ObjectAssert<T, U extends ObjectAssert<T, U>> {
  /**
   * Verifies that the Object does not have the same class as the value.
   *
   * @param value the value
   * @return the object assert
   */
  U doesNotHaveSameClassAs(Object value);

  /**
   * Verifies that the Object has the same class as the value.
   *
   * @param value the value
   * @return the object assert
   */
  U hasSameClassAs(Object value);

  /**
   * Verifies that the Object is equal to the value.
   *
   * @param value the value
   * @return the object assert
   */
  U isEqualTo(Object value);

  /**
   * Verifies that the Object is not equal to the value.
   *
   * @param value the value
   * @return the object assert
   */
  U isNotEqualTo(Object value);

  /**
   * Verifies that the Object is not the same as the value.
   *
   * @param value the value
   * @return the object assert
   */
  U isNotSameAs(Object value);

  /**
   * Verifies that the Object is the same as the value.
   *
   * @param value the value
   * @return the object assert
   */
  U isSameAs(Object value);

  /**
   * Verifies the actual.
   *
   * @param actual the actual
   */
  void verify(T actual);
}
