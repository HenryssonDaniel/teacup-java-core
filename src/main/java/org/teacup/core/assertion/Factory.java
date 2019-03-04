package org.teacup.core.assertion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Assertion factory.
 *
 * @since 1.0
 */
public enum Factory {
  ;

  private static final String LOG = "Creating %s assert";
  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());

  /**
   * Creates an char sequence assert.
   *
   * @return the char sequence assert
   */
  public static CharSequenceAssert<?, ?> createCharSequenceAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "char sequence"));
    return new CharSequenceAssertImpl<>();
  }

  /**
   * Creates an comparable assert.
   *
   * @param <T> the comparable type
   * @return the comparable assert
   */
  public static <T extends Comparable<? super T>> ComparableAssert<T, ?> createComparableAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "comparator"));
    return new ComparableAssertImpl<>();
  }

  /**
   * Creates an integer assert.
   *
   * @return the integer assert
   */
  public static IntegerAssert createIntegerAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "integer"));
    return new IntegerAssertImpl();
  }

  /**
   * Creates an iterable assert.
   *
   * @param <T> the iterable type
   * @return the iterable assert
   */
  public static <T> IterableAssert<T, ?, ?> createIterableAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "iterable"));
    return new IterableAssertImpl<>();
  }

  /**
   * Creates an list assert.
   *
   * @param <T> the list type
   * @return the list assert
   */
  public static <T> ListAssert<T, ?, ?> createListAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "list"));
    return new ListAssertImpl<>();
  }

  /**
   * Creates an map assert.
   *
   * @param <T> the map key type
   * @param <U> the map value type
   * @return the map assert
   */
  public static <T, U> MapAssert<T, U, ?, ?> createMapAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "map"));
    return new MapAssertImpl<>();
  }

  /**
   * Creates an object assert.
   *
   * @return the object assert
   */
  public static ObjectAssert<?, ?> createObjectAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "object"));
    return new ObjectAssertImpl<>();
  }

  /**
   * Creates an string assert.
   *
   * @return the string assert
   */
  public static StringAssert createStringAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "string"));
    return new StringAssertImpl();
  }
}
