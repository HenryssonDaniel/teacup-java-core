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

  private static final String LOG = "Creating {0} assert";
  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());

  /**
   * Creates an boolean array assert.
   *
   * @return the boolean array assert
   * @since 1.0
   */
  public static BooleanArrayAssert createBooleanArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "boolean array");
    return new BooleanArrayAssertImpl();
  }

  /**
   * Creates an boolean assert.
   *
   * @return the boolean assert
   * @since 1.0
   */
  public static BooleanAssert createBooleanAssert() {
    LOGGER.log(Level.FINE, LOG, "boolean");
    return new BooleanAssertImpl();
  }

  /**
   * Creates an byte array assert.
   *
   * @return the byte array assert
   * @since 1.0
   */
  public static ByteArrayAssert createByteArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "byte array");
    return new ByteArrayAssertImpl();
  }

  /**
   * Creates an char array assert.
   *
   * @return the char array assert
   * @since 1.0
   */
  public static CharArrayAssert createCharArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "char array");
    return new CharArrayAssertImpl();
  }

  /**
   * Creates an char sequence assert.
   *
   * @return the char sequence assert
   * @since 1.0
   */
  public static CharSequenceAssert createCharSequenceAssert() {
    LOGGER.log(Level.FINE, LOG, "char sequence");
    return new CharSequenceAssertImpl();
  }

  /**
   * Creates an comparable assert.
   *
   * @param <T> the comparable type
   * @return the comparable assert
   * @since 1.0
   */
  public static <T extends Comparable<? super T>> ComparableAssert<T> createComparableAssert() {
    LOGGER.log(Level.FINE, LOG, "comparator");
    return new ComparableAssertImpl<>();
  }

  /**
   * Creates an double array assert.
   *
   * @return the double array assert
   * @since 1.0
   */
  public static DoubleArrayAssert createDoubleArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "double array");
    return new DoubleArrayAssertImpl();
  }

  /**
   * Creates an float array assert.
   *
   * @return the float array assert
   * @since 1.0
   */
  public static FloatArrayAssert createFloatArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "float array");
    return new FloatArrayAssertImpl();
  }

  /**
   * Creates an int array assert.
   *
   * @return the int array assert
   * @since 1.0
   */
  public static IntArrayAssert createIntArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "int array");
    return new IntArrayAssertImpl();
  }

  /**
   * Creates an integer assert.
   *
   * @return the integer assert
   * @since 1.0
   */
  public static IntegerAssert createIntegerAssert() {
    LOGGER.log(Level.FINE, LOG, "integer");
    return new IntegerAssertImpl();
  }

  /**
   * Creates an iterable assert.
   *
   * @param <T> the type
   * @return the iterable assert
   * @since 1.0
   */
  public static <T> IterableAssert<T> createIterableAssert() {
    LOGGER.log(Level.FINE, LOG, "iterable");
    return new IterableAssertImpl<>();
  }

  /**
   * Creates an list assert.
   *
   * @param <T> the list type
   * @return the list assert
   * @since 1.0
   */
  public static <T> ListAssert<T> createListAssert() {
    LOGGER.log(Level.FINE, LOG, "list");
    return new ListAssertImpl<>();
  }

  /**
   * Creates an long array assert.
   *
   * @return the long array assert
   * @since 1.0
   */
  public static LongArrayAssert createLongArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "long array");
    return new LongArrayAssertImpl();
  }

  /**
   * Creates an long assert.
   *
   * @return the long assert
   * @since 1.0
   */
  public static LongAssert createLongAssert() {
    LOGGER.log(Level.FINE, LOG, "long");
    return new LongAssertImpl();
  }

  /**
   * Creates an map assert.
   *
   * @param <T> the map key type
   * @param <U> the map value type
   * @return the map assert
   * @since 1.0
   */
  public static <T, U> MapAssert<T, U> createMapAssert() {
    LOGGER.log(Level.FINE, LOG, "map");
    return new MapAssertImpl<>();
  }

  /**
   * Creates an object array assert.
   *
   * @return the object array assert
   * @since 1.0
   */
  public static ObjectArrayAssert createObjectArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "object array");
    return new ObjectArrayAssertImpl();
  }

  /**
   * Creates an object assert.
   *
   * @return the object assert
   * @since 1.0
   */
  public static ObjectAssert createObjectAssert() {
    LOGGER.log(Level.FINE, LOG, "object");
    return new ObjectAssertImpl();
  }

  /**
   * Creates an short array assert.
   *
   * @return the short array assert
   * @since 1.0
   */
  public static ShortArrayAssert createShortArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "short array");
    return new ShortArrayAssertImpl();
  }

  /**
   * Creates an string assert.
   *
   * @return the string assert
   * @since 1.0
   */
  public static StringAssert createStringAssert() {
    LOGGER.log(Level.FINE, LOG, "string");
    return new StringAssertImpl();
  }
}
