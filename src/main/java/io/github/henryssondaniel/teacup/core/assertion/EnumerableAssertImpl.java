package io.github.henryssondaniel.teacup.core.assertion;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractAssert;

abstract class EnumerableAssertImpl<T, U extends EnumerableAssert<T, U>>
    extends AbstractObjectAssert<T, U> implements EnumerableAssert<T, U> {
  private static final Logger LOGGER = Factory.getLogger(EnumerableAssertImpl.class);

  @Override
  public U hasSameSizeAs(Iterable<?> other) {
    List<String> otherAsString = new LinkedList<>();
    other.forEach(value -> otherAsString.add(value.toString()));

    LOGGER.log(Level.FINE, "Has same size as: {0}", Arrays.toString(otherAsString.toArray()));
    addSupplier(() -> getEnumerableAssert().hasSameSizeAs(other));

    return getAssertType();
  }

  @Override
  public U hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same siz as: {0}", array);
    addSupplier(() -> getEnumerableAssert().hasSameSizeAs(array));
    return getAssertType();
  }

  @Override
  public U hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: {0}", expected);
    addSupplier(() -> getEnumerableAssert().hasSize(expected));
    return getAssertType();
  }

  @Override
  public U isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(() -> getEnumerableAssert().isEmpty());
    return getAssertType();
  }

  @Override
  public U isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(() -> getEnumerableAssert().isNotEmpty());
    return getAssertType();
  }

  @Override
  public U isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(() -> getEnumerableAssert().isNullOrEmpty());
    return getAssertType();
  }

  @Override
  abstract <V extends AbstractAssert<V, T>> AbstractAssert<V, T> getAssert();

  private org.assertj.core.api.EnumerableAssert<?, ?> getEnumerableAssert() {
    return (org.assertj.core.api.EnumerableAssert<?, ?>) getAssert();
  }
}
