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
   * @param <T> the boolean array assert type
   * @return the boolean array assert
   * @since 1.0
   */
  public static <T extends BooleanArrayAssert<T>> BooleanArrayAssert<T> createBooleanArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "boolean array");
    return new BooleanArrayAssertImpl<>();
  }

  /**
   * Creates an boolean assert.
   *
   * @param <T> the boolean assert type
   * @return the boolean assert
   * @since 1.0
   */
  public static <T extends BooleanAssert<T>> BooleanAssert<T> createBooleanAssert() {
    LOGGER.log(Level.FINE, LOG, "boolean");
    return new BooleanAssertImpl<>();
  }

  /**
   * Creates an byte array assert.
   *
   * @param <T> the byte array assert type
   * @return the byte array assert
   * @since 1.0
   */
  public static <T extends ByteArrayAssert<T>> ByteArrayAssert<T> createByteArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "byte array");
    return new ByteArrayAssertImpl<>();
  }

  /**
   * Creates an char array assert.
   *
   * @param <T> the char array assert type
   * @return the char array assert
   * @since 1.0
   */
  public static <T extends CharArrayAssert<T>> CharArrayAssert<T> createCharArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "char array");
    return new CharArrayAssertImpl<>();
  }

  /**
   * Creates an char sequence assert.
   *
   * @param <T> the type
   * @param <U> the char sequence assert type
   * @return the char sequence assert
   * @since 1.0
   */
  public static <T extends CharSequence, U extends CharSequenceAssert<T, U>>
      CharSequenceAssert<T, U> createCharSequenceAssert() {
    LOGGER.log(Level.FINE, LOG, "char sequence");
    return new CharSequenceAssertImpl<>();
  }

  /**
   * Creates an comparable assert.
   *
   * @param <T> the comparable type
   * @param <U> the comparable assert type
   * @return the comparable assert
   * @since 1.0
   */
  public static <T extends Comparable<? super T>, U extends ComparableAssert<T, U>>
      ComparableAssert<T, U> createComparableAssert() {
    LOGGER.log(Level.FINE, LOG, "comparator");
    return new ComparableAssertImpl<>();
  }

  /**
   * Creates an double array assert.
   *
   * @param <T> the double array assert type
   * @return the double array assert
   * @since 1.0
   */
  public static <T extends DoubleArrayAssert<T>> DoubleArrayAssert<T> createDoubleArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "double array");
    return new DoubleArrayAssertImpl<>();
  }

  /**
   * Creates an float array assert.
   *
   * @param <T> the float array assert type
   * @return the float array assert
   * @since 1.0
   */
  public static <T extends FloatArrayAssert<T>> FloatArrayAssert<T> createFloatArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "float array");
    return new FloatArrayAssertImpl<>();
  }

  /**
   * Creates an int array assert.
   *
   * @param <T> the int array assert type
   * @return the int array assert
   * @since 1.0
   */
  public static <T extends IntArrayAssert<T>> IntArrayAssert<T> createIntArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "int array");
    return new IntArrayAssertImpl<>();
  }

  /**
   * Creates an integer assert.
   *
   * @param <T> the integer assert type
   * @return the integer assert
   * @since 1.0
   */
  public static <T extends IntegerAssert<T>> IntegerAssert<T> createIntegerAssert() {
    LOGGER.log(Level.FINE, LOG, "integer");
    return new IntegerAssertImpl<>();
  }

  /**
   * Creates an iterable assert.
   *
   * @param <T> the type
   * @param <U> the iterable type
   * @param <V> the iterable assert type
   * @return the iterable assert
   * @since 1.0
   */
  public static <T, U extends Iterable<? extends T>, V extends IterableAssert<T, U, V>>
      IterableAssert<T, U, V> createIterableAssert() {
    LOGGER.log(Level.FINE, LOG, "iterable");
    return new IterableAssertImpl<>();
  }

  /**
   * Creates an list assert.
   *
   * @param <T> the list type
   * @param <U> the list assert type
   * @return the list assert
   * @since 1.0
   */
  public static <T, U extends ListAssert<T, U>> ListAssert<T, U> createListAssert() {
    LOGGER.log(Level.FINE, LOG, "list");
    return new ListAssertImpl<>();
  }

  /**
   * Creates an long array assert.
   *
   * @param <T> the long array assert type
   * @return the long array assert
   * @since 1.0
   */
  public static <T extends LongArrayAssert<T>> LongArrayAssert<T> createLongArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "long array");
    return new LongArrayAssertImpl<>();
  }

  /**
   * Creates an long assert.
   *
   * @param <T> the long assert type
   * @return the long assert
   * @since 1.0
   */
  public static <T extends LongAssert<T>> LongAssert<T> createLongAssert() {
    LOGGER.log(Level.FINE, LOG, "long");
    return new LongAssertImpl<>();
  }

  /**
   * Creates an map assert.
   *
   * @param <T> the map key type
   * @param <U> the map value type
   * @param <V> the map assert type
   * @return the map assert
   * @since 1.0
   */
  public static <T, U, V extends MapAssert<T, U, V>> MapAssert<T, U, V> createMapAssert() {
    LOGGER.log(Level.FINE, LOG, "map");
    return new MapAssertImpl<>();
  }

  /**
   * Creates an object array assert.
   *
   * @param <T> the type
   * @param <U> the object array assert type
   * @return the object array assert
   * @since 1.0
   */
  public static <T, U extends ObjectArrayAssert<T, U>>
      ObjectArrayAssert<T, U> createObjectArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "object array");
    return new ObjectArrayAssertImpl<>();
  }

  /**
   * Creates an object assert.
   *
   * @param <T> the type
   * @param <U> the object assert type
   * @return the object assert
   * @since 1.0
   */
  public static <T, U extends ObjectAssert<T, U>> ObjectAssert<T, U> createObjectAssert() {
    LOGGER.log(Level.FINE, LOG, "object");
    return new ObjectAssertImpl<>();
  }

  /**
   * Creates an short array assert.
   *
   * @param <T> the short array assert type
   * @return the short array assert
   * @since 1.0
   */
  public static <T extends ShortArrayAssert<T>> ShortArrayAssert<T> createShortArrayAssert() {
    LOGGER.log(Level.FINE, LOG, "short array");
    return new ShortArrayAssertImpl<>();
  }

  /**
   * Creates an string assert.
   *
   * @param <T> the string assert type
   * @return the string assert
   * @since 1.0
   */
  public static <T extends StringAssert<T>> StringAssert<T> createStringAssert() {
    LOGGER.log(Level.FINE, LOG, "string");
    return new StringAssertImpl<>();
  }
}
