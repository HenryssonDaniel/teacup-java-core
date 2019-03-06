package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

class MapAssertImpl<T, U, V extends MapAssert<T, U, V>> extends ObjectAssertImpl<Map<T, U>, V>
    implements MapAssert<T, U, V> {
  private static final Logger LOGGER = Logger.getLogger(MapAssertImpl.class.getName());

  @Override
  public V contains(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains: " + Arrays.toString(entries));
    addSupplier(() -> getAssert().contains(entries));
    return getAssertType();
  }

  @Override
  public V containsAllEntriesOf(Map<? extends T, ? extends U> map) {
    var stringBuilder = new StringBuilder(0);
    map.forEach((key, value) -> stringBuilder.append(key).append(", ").append(value));

    LOGGER.log(Level.FINE, "Contains all entries of: " + stringBuilder);
    addSupplier(() -> getAssert().containsAllEntriesOf(map));

    return getAssertType();
  }

  @Override
  public V containsAnyOf(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains any of: " + Arrays.toString(entries));
    addSupplier(() -> getAssert().containsAnyOf(entries));
    return getAssertType();
  }

  @Override
  public V containsEntry(T key, U value) {
    LOGGER.log(Level.FINE, "Contains entry with key: " + key + ", value: " + value);
    addSupplier(() -> getAssert().containsEntry(key, value));
    return getAssertType();
  }

  @Override
  public V containsExactly(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains exactly: " + Arrays.toString(entries));
    addSupplier(() -> getAssert().containsExactly(entries));
    return getAssertType();
  }

  @Override
  public V containsKey(T key) {
    LOGGER.log(Level.FINE, "Contains key: " + key);
    addSupplier(() -> getAssert().containsKey(key));
    return getAssertType();
  }

  @Override
  public V containsKeys(T... keys) {
    LOGGER.log(Level.FINE, "Contains keys: " + Arrays.toString(keys));
    addSupplier(() -> getAssert().containsKeys(keys));
    return getAssertType();
  }

  @Override
  public V containsOnly(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains only: " + Arrays.toString(entries));
    addSupplier(() -> getAssert().containsOnly(entries));
    return getAssertType();
  }

  @Override
  public V containsOnlyKeys(T... keys) {
    LOGGER.log(Level.FINE, "Contains only keys: " + Arrays.toString(keys));
    addSupplier(() -> getAssert().containsOnlyKeys(keys));
    return getAssertType();
  }

  @Override
  public V containsValue(U value) {
    LOGGER.log(Level.FINE, "Contains value: " + value);
    addSupplier(() -> getAssert().containsValue(value));
    return getAssertType();
  }

  @Override
  public V containsValues(U... values) {
    LOGGER.log(Level.FINE, "Contains values: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsValues(values));
    return getAssertType();
  }

  @Override
  public V doesNotContain(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Does not contain: " + Arrays.toString(entries));
    addSupplier(() -> getAssert().doesNotContain(entries));
    return getAssertType();
  }

  @Override
  public V doesNotContainEntry(T key, U value) {
    LOGGER.log(Level.FINE, "Does not contain entry with key: " + key + ", value: " + value);
    addSupplier(() -> getAssert().doesNotContainEntry(key, value));
    return getAssertType();
  }

  @Override
  public V doesNotContainKey(T key) {
    LOGGER.log(Level.FINE, "Does not contain key: " + key);
    addSupplier(() -> getAssert().doesNotContainKey(key));
    return getAssertType();
  }

  @Override
  public V doesNotContainKeys(T... keys) {
    LOGGER.log(Level.FINE, "Does not contain keys: " + Arrays.toString(keys));
    addSupplier(() -> getAssert().doesNotContainKeys(keys));
    return getAssertType();
  }

  @Override
  public V doesNotContainValue(U value) {
    LOGGER.log(Level.FINE, "Does not contain value: " + value);
    addSupplier(() -> getAssert().doesNotContainValue(value));
    return getAssertType();
  }

  @Override
  public V hasSameSizeAs(Map<?, ?> map) {
    LOGGER.log(Level.FINE, "Has same size as: " + map.size());
    addSupplier(() -> getAssert().hasSameSizeAs(map));
    return getAssertType();
  }

  @Override
  public V hasSameSizeAs(Iterable<?> other) {
    var size = 0;
    for (Object ignore : other) size++;

    LOGGER.log(Level.FINE, "Has same size as: " + size);
    addSupplier(() -> getAssert().hasSameSizeAs(other));

    return getAssertType();
  }

  @Override
  public V hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same size as: " + array);
    addSupplier(() -> getAssert().hasSameSizeAs(array));
    return getAssertType();
  }

  @Override
  public V hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: " + expected);
    addSupplier(() -> getAssert().hasSize(expected));
    return getAssertType();
  }

  @Override
  public V isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(() -> getAssert().isEmpty());
    return getAssertType();
  }

  @Override
  public V isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(() -> getAssert().isNotEmpty());
    return getAssertType();
  }

  @Override
  public V isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(() -> getAssert().isNullOrEmpty());
    return getAssertType();
  }

  @Override
  org.assertj.core.api.MapAssert<T, U> getAssert() {
    return assertThat(getActual());
  }
}
