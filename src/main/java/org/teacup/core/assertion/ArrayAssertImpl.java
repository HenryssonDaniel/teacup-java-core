package org.teacup.core.assertion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractArrayAssert;

abstract class ArrayAssertImpl<T, U extends ArrayAssert<T, U>> extends ObjectAssertImpl<T, U>
    implements ArrayAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(ArrayAssertImpl.class.getName());

  @Override
  public U hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same siz as: " + array);
    addSupplier(() -> getAssert().hasSameSizeAs(array));
    return getAssertType();
  }

  @Override
  public U hasSameSizeAs(Iterable<?> other) {
    List<String> otherAsString = new LinkedList<>();
    other.forEach(value -> otherAsString.add(value.toString()));

    LOGGER.log(Level.FINE, "Has same size as: " + Arrays.toString(otherAsString.toArray()));
    addSupplier(() -> getAssert().hasSameSizeAs(other));

    return getAssertType();
  }

  @Override
  public U hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: " + expected);
    addSupplier(() -> getAssert().hasSize(expected));
    return getAssertType();
  }

  @Override
  public U isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(() -> getAssert().isEmpty());
    return getAssertType();
  }

  @Override
  public U isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(() -> getAssert().isNotEmpty());
    return getAssertType();
  }

  @Override
  public U isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(() -> getAssert().isNullOrEmpty());
    return getAssertType();
  }

  @Override
  abstract AbstractArrayAssert<?, T, ?> getAssert();
}
