package io.github.henryssondaniel.teacup.core.assertion;

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
   * Creates an boolean array assert.
   *
   * @return the boolean array assert
   */
  public static BooleanArrayAssert<?> createBooleanArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "boolean array"));
    return new BooleanArrayAssertImpl<>();
  }

  /**
   * Creates an boolean assert.
   *
   * @return the boolean assert
   */
  public static BooleanAssert<?> createBooleanAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "boolean"));
    return new BooleanAssertImpl<>();
  }

  /**
   * Creates an byte array assert.
   *
   * @return the byte array assert
   */
  public static ByteArrayAssert<?> createByteArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "byte array"));
    return new ByteArrayAssertImpl<>();
  }

  /**
   * Creates an char array assert.
   *
   * @return the char array assert
   */
  public static CharArrayAssert<?> createCharArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "char array"));
    return new CharArrayAssertImpl<>();
  }

  /**
   * Creates an char sequence assert.
   *
   * @param <T> the type
   * @return the char sequence assert
   */
  public static <T extends CharSequence> CharSequenceAssert<T, ?> createCharSequenceAssert() {
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
   * Creates an double array assert.
   *
   * @return the double array assert
   */
  public static DoubleArrayAssert<?> createDoubleArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "double array"));
    return new DoubleArrayAssertImpl<>();
  }

  /**
   * Creates an float array assert.
   *
   * @return the float array assert
   */
  public static FloatArrayAssert<?> createFloatArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "float array"));
    return new FloatArrayAssertImpl<>();
  }

  /**
   * Creates an int array assert.
   *
   * @return the int array assert
   */
  public static IntArrayAssert<?> createIntArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "int array"));
    return new IntArrayAssertImpl<>();
  }

  /**
   * Creates an integer assert.
   *
   * @return the integer assert
   */
  public static IntegerAssert<?> createIntegerAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "integer"));
    return new IntegerAssertImpl<>();
  }

  /**
   * Creates an iterable assert.
   *
   * @param <T> the type
   * @param <U> the iterable type
   * @return the iterable assert
   */
  public static <T, U extends Iterable<? extends T>>
      IterableAssert<T, U, ?> createIterableAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "iterable"));
    return new IterableAssertImpl<>();
  }

  /**
   * Creates an list assert.
   *
   * @param <T> the list type
   * @return the list assert
   */
  public static <T> ListAssert<T, ?> createListAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "list"));
    return new ListAssertImpl<>();
  }

  /**
   * Creates an long array assert.
   *
   * @return the long array assert
   */
  public static LongArrayAssert<?> createLongArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "long array"));
    return new LongArrayAssertImpl<>();
  }

  /**
   * Creates an long assert.
   *
   * @return the long assert
   */
  public static LongAssert<?> createLongAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "long"));
    return new LongAssertImpl<>();
  }

  /**
   * Creates an map assert.
   *
   * @param <T> the map key type
   * @param <U> the map value type
   * @return the map assert
   */
  public static <T, U> MapAssert<T, U, ?> createMapAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "map"));
    return new MapAssertImpl<>();
  }

  /**
   * Creates an object array assert.
   *
   * @param <T> the type
   * @return the object array assert
   */
  public static <T> ObjectArrayAssert<T, ?> createObjectArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "object array"));
    return new ObjectArrayAssertImpl<>();
  }

  /**
   * Creates an object assert.
   *
   * @param <T> the type
   * @return the object assert
   */
  public static <T> ObjectAssert<T, ?> createObjectAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "object"));
    return new ObjectAssertImpl<>();
  }

  /**
   * Creates an short array assert.
   *
   * @return the short array assert
   */
  public static ShortArrayAssert<?> createShortArrayAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "short array"));
    return new ShortArrayAssertImpl<>();
  }

  /**
   * Creates an string assert.
   *
   * @return the string assert
   */
  public static StringAssert<?> createStringAssert() {
    LOGGER.log(Level.FINE, String.format(LOG, "string"));
    return new StringAssertImpl<>();
  }
}
