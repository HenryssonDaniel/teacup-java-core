package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

class MapAssertImpl<T, U, V extends MapAssert<T, U, V>> extends EnumerableAssertImpl<Map<T, U>, V>
    implements MapAssert<T, U, V> {
  private static final Logger LOGGER = Logger.getLogger(MapAssertImpl.class.getName());

  @Override
  public V contains(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains: {0}", Arrays.toString(entries));
    addSupplier(() -> getAssert().contains(entries));
    return getAssertType();
  }

  @Override
  public V containsAllEntriesOf(Map<? extends T, ? extends U> map) {
    var stringBuilder = new StringBuilder(0);
    map.forEach((key, value) -> stringBuilder.append(key).append(", ").append(value));

    LOGGER.log(Level.FINE, "Contains all entries of: {0}", stringBuilder);
    addSupplier(() -> getAssert().containsAllEntriesOf(map));

    return getAssertType();
  }

  @Override
  public V containsAnyOf(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains any of: {0}", Arrays.toString(entries));
    addSupplier(() -> getAssert().containsAnyOf(entries));
    return getAssertType();
  }

  @Override
  public V containsEntry(T key, U value) {
    LOGGER.log(Level.FINE, "Contains entry with key: {0}, value: {1}", new Object[] {key, value});
    addSupplier(() -> getAssert().containsEntry(key, value));
    return getAssertType();
  }

  @Override
  public V containsExactly(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains exactly: {0}", Arrays.toString(entries));
    addSupplier(() -> getAssert().containsExactly(entries));
    return getAssertType();
  }

  @Override
  public V containsKey(T key) {
    LOGGER.log(Level.FINE, "Contains key: {0}", key);
    addSupplier(() -> getAssert().containsKey(key));
    return getAssertType();
  }

  @Override
  public V containsKeys(T... keys) {
    LOGGER.log(Level.FINE, "Contains keys: {0}", Arrays.toString(keys));
    addSupplier(() -> getAssert().containsKeys(keys));
    return getAssertType();
  }

  @Override
  public V containsOnly(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Contains only: {0}", Arrays.toString(entries));
    addSupplier(() -> getAssert().containsOnly(entries));
    return getAssertType();
  }

  @Override
  public V containsOnlyKeys(T... keys) {
    LOGGER.log(Level.FINE, "Contains only keys: {0}", Arrays.toString(keys));
    addSupplier(() -> getAssert().containsOnlyKeys(keys));
    return getAssertType();
  }

  @Override
  public V containsValue(U value) {
    LOGGER.log(Level.FINE, "Contains value: {0}", value);
    addSupplier(() -> getAssert().containsValue(value));
    return getAssertType();
  }

  @Override
  public V containsValues(U... values) {
    LOGGER.log(Level.FINE, "Contains values: {0}", Arrays.toString(values));
    addSupplier(() -> getAssert().containsValues(values));
    return getAssertType();
  }

  @Override
  public V doesNotContain(Entry<? extends T, ? extends U>... entries) {
    LOGGER.log(Level.FINE, "Does not contain: {0}", Arrays.toString(entries));
    addSupplier(() -> getAssert().doesNotContain(entries));
    return getAssertType();
  }

  @Override
  public V doesNotContainEntry(T key, U value) {
    LOGGER.log(
        Level.FINE, "Does not contain entry with key: {0}, value: {1}", new Object[] {key, value});
    addSupplier(() -> getAssert().doesNotContainEntry(key, value));
    return getAssertType();
  }

  @Override
  public V doesNotContainKey(T key) {
    LOGGER.log(Level.FINE, "Does not contain key: {0}", key);
    addSupplier(() -> getAssert().doesNotContainKey(key));
    return getAssertType();
  }

  @Override
  public V doesNotContainKeys(T... keys) {
    LOGGER.log(Level.FINE, "Does not contain keys: {0}", Arrays.toString(keys));
    addSupplier(() -> getAssert().doesNotContainKeys(keys));
    return getAssertType();
  }

  @Override
  public V doesNotContainValue(U value) {
    LOGGER.log(Level.FINE, "Does not contain value: {0}", value);
    addSupplier(() -> getAssert().doesNotContainValue(value));
    return getAssertType();
  }

  @Override
  public V hasSameSizeAs(Map<?, ?> map) {
    LOGGER.log(Level.FINE, "Has same size as: {0}", map.size());
    addSupplier(() -> getAssert().hasSameSizeAs(map));
    return getAssertType();
  }

  @Override
  org.assertj.core.api.MapAssert<T, U> getAssert() {
    return assertThat(getActual());
  }
}
