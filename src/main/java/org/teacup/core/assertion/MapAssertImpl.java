package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

class MapAssertImpl<T, U, V extends Map<T, U>, X extends MapAssert<T, U, V, X>>
    extends ObjectAssertImpl<V, X> implements MapAssert<T, U, V, X> {
  private static final Logger LOGGER = Logger.getLogger(MapAssertImpl.class.getName());

  @Override
  public X contains(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains: " + Arrays.toString(entries));
    addSupplier(actual -> assertThat(actual).contains(entries));
    return returnAssertType();
  }

  @Override
  public X containsAllEntriesOf(Map<? extends T, ? extends U> map) {
    var stringBuilder = new StringBuilder(0);
    map.forEach((key, value) -> stringBuilder.append(key).append(", ").append(value));

    LOGGER.log(Level.FINE, "Contains all entries of: " + stringBuilder);
    addSupplier(actual -> assertThat(actual).containsAllEntriesOf(map));

    return returnAssertType();
  }

  @Override
  public X containsAnyOf(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains any of: " + Arrays.toString(entries));
    addSupplier(actual -> assertThat(actual).containsAnyOf(entries));
    return returnAssertType();
  }

  @Override
  public X containsEntry(T key, U value) {
    LOGGER.log(Level.FINE, "Contains entry with key: " + key + ", value: " + value);
    addSupplier(actual -> assertThat(actual).containsEntry(key, value));
    return returnAssertType();
  }

  @Override
  public X containsExactly(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains exactly: " + Arrays.toString(entries));
    addSupplier(actual -> assertThat(actual).containsExactly(entries));
    return returnAssertType();
  }

  @Override
  public X containsKey(T key) {
    LOGGER.log(Level.FINE, "Contains key: " + key);
    addSupplier(actual -> assertThat(actual).containsKey(key));
    return returnAssertType();
  }

  @Override
  public X containsKeys(T... keys) {
    LOGGER.log(Level.FINE, "Contains keys: " + Arrays.toString(keys));
    addSupplier(actual -> assertThat(actual).containsKeys(keys));
    return returnAssertType();
  }

  @Override
  public X containsOnly(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains only: " + Arrays.toString(entries));
    addSupplier(actual -> assertThat(actual).containsOnly(entries));
    return returnAssertType();
  }

  @Override
  public X containsOnlyKeys(T... keys) {
    LOGGER.log(Level.FINE, "Contains only keys: " + Arrays.toString(keys));
    addSupplier(actual -> assertThat(actual).containsOnlyKeys(keys));
    return returnAssertType();
  }

  @Override
  public X containsValue(U value) {
    LOGGER.log(Level.FINE, "Contains value: " + value);
    addSupplier(actual -> assertThat(actual).containsValue(value));
    return returnAssertType();
  }

  @Override
  public X containsValues(U... values) {
    LOGGER.log(Level.FINE, "Contains values: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsValues(values));
    return returnAssertType();
  }

  @Override
  public X doesNotContain(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Does not contain: " + Arrays.toString(entries));
    addSupplier(actual -> assertThat(actual).doesNotContain(entries));
    return returnAssertType();
  }

  @Override
  public X doesNotContainEntry(T key, U value) {
    LOGGER.log(Level.FINE, "Does not contain entry with key: " + key + ", value: " + value);
    addSupplier(actual -> assertThat(actual).doesNotContainEntry(key, value));
    return returnAssertType();
  }

  @Override
  public X doesNotContainKey(T key) {
    LOGGER.log(Level.FINE, "Does not contain key: " + key);
    addSupplier(actual -> assertThat(actual).doesNotContainKey(key));
    return returnAssertType();
  }

  @Override
  public X doesNotContainKeys(T... keys) {
    LOGGER.log(Level.FINE, "Does not contain keys: " + Arrays.toString(keys));
    addSupplier(actual -> assertThat(actual).doesNotContainKeys(keys));
    return returnAssertType();
  }

  @Override
  public X doesNotContainValue(U value) {
    LOGGER.log(Level.FINE, "Does not contain value: " + value);
    addSupplier(actual -> assertThat(actual).doesNotContainValue(value));
    return returnAssertType();
  }

  @Override
  public X hasSameSizeAs(Map<?, ?> map) {
    LOGGER.log(Level.FINE, "Has same size as: " + map.size());
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(map));
    return returnAssertType();
  }

  @Override
  public X hasSameSizeAs(Iterable<?> other) {
    var size = 0;
    for (Object ignore : other) size++;

    LOGGER.log(Level.FINE, "Has same size as: " + size);
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(other));

    return returnAssertType();
  }

  @Override
  public X hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same size as: " + array);
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(array));
    return returnAssertType();
  }

  @Override
  public X hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: " + expected);
    addSupplier(actual -> assertThat(actual).hasSize(expected));
    return returnAssertType();
  }

  @Override
  public X isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(actual -> assertThat(actual).isEmpty());
    return returnAssertType();
  }

  @Override
  public X isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(actual -> assertThat(actual).isNotEmpty());
    return returnAssertType();
  }

  @Override
  public X isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(actual -> assertThat(actual).isNullOrEmpty());
    return returnAssertType();
  }
}
