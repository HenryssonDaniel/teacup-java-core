package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class IterableAssertImpl<T, U extends Iterable<T>, V extends IterableAssert<T, U, V>>
    extends ObjectAssertImpl<U, V> implements IterableAssert<T, U, V> {
  private static final Logger LOGGER = Logger.getLogger(IterableAssertImpl.class.getName());

  @Override
  public V contains(T... values) {
    LOGGER.log(Level.FINE, "Contains: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).contains(values));
    return returnAssertType();
  }

  @Override
  public V containsAll(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains all: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).containsAll(iterable));
    return returnAssertType();
  }

  @Override
  public V containsAnyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains any elements of: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).containsAnyElementsOf(iterable));
    return returnAssertType();
  }

  @Override
  public V containsAnyOf(T... values) {
    LOGGER.log(Level.FINE, "Contains any of: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsAnyOf(values));
    return returnAssertType();
  }

  @Override
  public V containsExactly(T... values) {
    LOGGER.log(Level.FINE, "Contains exactly: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsExactly(values));
    return returnAssertType();
  }

  @Override
  public V containsExactlyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains exactly element of: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).containsExactlyElementsOf(iterable));
    return returnAssertType();
  }

  @Override
  public V containsExactlyInAnyOrder(T... values) {
    LOGGER.log(Level.FINE, "Contains exactly in any order: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsExactlyInAnyOrder(values));
    return returnAssertType();
  }

  @Override
  public V containsExactlyInAnyOrderElementsOf(Iterable<? extends T> values) {
    LOGGER.log(
        Level.FINE, "Contains exactly in any order elements of: " + iterableToString(values));
    addSupplier(actual -> assertThat(actual).containsExactlyInAnyOrderElementsOf(values));
    return returnAssertType();
  }

  @Override
  public V containsNull() {
    LOGGER.log(Level.FINE, "Contains null");
    addSupplier(actual -> assertThat(actual).containsNull());
    return returnAssertType();
  }

  @Override
  public V containsOnly(T... values) {
    LOGGER.log(Level.FINE, "Contains only: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsOnly(values));
    return returnAssertType();
  }

  @Override
  public V containsOnlyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains only elements of: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).containsOnlyElementsOf(iterable));
    return returnAssertType();
  }

  @Override
  public V containsOnlyNulls() {
    LOGGER.log(Level.FINE, "Contains only null");
    addSupplier(actual -> assertThat(actual).containsOnlyNulls());
    return returnAssertType();
  }

  @Override
  public V containsOnlyOnce(T... values) {
    LOGGER.log(Level.FINE, "Contains only once: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsOnlyOnce(values));
    return returnAssertType();
  }

  @Override
  public V containsSequence(T... sequence) {
    LOGGER.log(Level.FINE, "Contains sequence: " + Arrays.toString(sequence));
    addSupplier(actual -> assertThat(actual).containsSequence(sequence));
    return returnAssertType();
  }

  @Override
  public V containsSequence(Iterable<? extends T> sequence) {
    LOGGER.log(Level.FINE, "Contains sequence: " + iterableToString(sequence));
    addSupplier(actual -> assertThat(actual).containsSequence(sequence));
    return returnAssertType();
  }

  @Override
  public V containsSubsequence(T... subsequence) {
    LOGGER.log(Level.FINE, "Contains sub sequence: " + Arrays.toString(subsequence));
    addSupplier(actual -> assertThat(actual).containsSubsequence(subsequence));
    return returnAssertType();
  }

  @Override
  public V containsSubsequence(Iterable<? extends T> subsequence) {
    LOGGER.log(Level.FINE, "Contains sub sequence: " + iterableToString(subsequence));
    addSupplier(actual -> assertThat(actual).containsSubsequence(subsequence));
    return returnAssertType();
  }

  @Override
  public V doesNotContain(T... values) {
    LOGGER.log(Level.FINE, "Does not contain: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).doesNotContain(values));
    return returnAssertType();
  }

  @Override
  public V doesNotContainAnyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Does not contain any elements of: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).doesNotContainAnyElementsOf(iterable));
    return returnAssertType();
  }

  @Override
  public V doesNotContainNull() {
    LOGGER.log(Level.FINE, "Does not contain null");
    addSupplier(actual -> assertThat(actual).doesNotContainNull());
    return returnAssertType();
  }

  @Override
  public V doesNotContainSequence(T... sequence) {
    LOGGER.log(Level.FINE, "Does not contain sequence: " + Arrays.toString(sequence));
    addSupplier(actual -> assertThat(actual).doesNotContainSequence(sequence));
    return returnAssertType();
  }

  @Override
  public V doesNotContainSequence(Iterable<? extends T> sequence) {
    LOGGER.log(Level.FINE, "Does not contain sequence: " + iterableToString(sequence));
    addSupplier(actual -> assertThat(actual).doesNotContainSequence(sequence));
    return returnAssertType();
  }

  @Override
  public V doesNotContainSubsequence(T... subsequence) {
    LOGGER.log(Level.FINE, "Does not contain sub sequence: " + Arrays.toString(subsequence));
    addSupplier(actual -> assertThat(actual).doesNotContainSubsequence(subsequence));
    return returnAssertType();
  }

  @Override
  public V doesNotContainSubsequence(Iterable<? extends T> subsequence) {
    LOGGER.log(Level.FINE, "Does not contain sub sequence: " + iterableToString(subsequence));
    addSupplier(actual -> assertThat(actual).doesNotContainSubsequence(subsequence));
    return returnAssertType();
  }

  @Override
  public V doesNotHaveAnyElementsOfTypes(Class<?>... types) {
    LOGGER.log(Level.FINE, "Does not have any elements of types: " + Arrays.toString(types));
    addSupplier(actual -> assertThat(actual).doesNotHaveAnyElementsOfTypes(types));
    return returnAssertType();
  }

  @Override
  public V doesNotHaveDuplicates() {
    LOGGER.log(Level.FINE, "Does not have duplicates");
    addSupplier(actual -> assertThat(actual).doesNotHaveDuplicates());
    return returnAssertType();
  }

  @Override
  public V endsWith(T... sequence) {
    LOGGER.log(Level.FINE, "Ends with: " + Arrays.toString(sequence));
    addSupplier(actual -> assertThat(actual).endsWith(sequence));
    return returnAssertType();
  }

  @Override
  public V hasAtLeastOneElementOfType(Class<?> type) {
    LOGGER.log(Level.FINE, "Has at least one element of type: " + type.getName());
    addSupplier(actual -> assertThat(actual).hasAtLeastOneElementOfType(type));
    return returnAssertType();
  }

  @Override
  public V hasOnlyElementsOfType(Class<?> type) {
    LOGGER.log(Level.FINE, "Has only elements of type " + type.getName());
    addSupplier(actual -> assertThat(actual).hasOnlyElementsOfType(type));
    return returnAssertType();
  }

  @Override
  public V hasOnlyElementsOfTypes(Class<?>... types) {
    LOGGER.log(Level.FINE, "Has only elements of types: " + Arrays.toString(types));
    addSupplier(actual -> assertThat(actual).hasOnlyElementsOfTypes(types));
    return returnAssertType();
  }

  @Override
  public V hasSameElementsAs(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Has same elements as: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).hasSameElementsAs(iterable));
    return returnAssertType();
  }

  @Override
  public V hasSameSizeAs(Iterable<?> other) {
    LOGGER.log(Level.FINE, "Has same size as: " + iterableToString(other));
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(other));
    return returnAssertType();
  }

  @Override
  public V hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same size as: " + array);
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(array));
    return returnAssertType();
  }

  @Override
  public V hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: " + expected);
    addSupplier(actual -> assertThat(actual).hasSize(expected));
    return returnAssertType();
  }

  @Override
  public V isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(actual -> assertThat(actual).isEmpty());
    return returnAssertType();
  }

  @Override
  public V isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(actual -> assertThat(actual).isNotEmpty());
    return returnAssertType();
  }

  @Override
  public V isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(actual -> assertThat(actual).isNullOrEmpty());
    return returnAssertType();
  }

  @Override
  public V isSubsetOf(T... values) {
    LOGGER.log(Level.FINE, "Is subset of: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).isSubsetOf(values));
    return returnAssertType();
  }

  @Override
  public V isSubsetOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Is subset of: " + iterableToString(iterable));
    addSupplier(actual -> assertThat(actual).isSubsetOf(iterable));
    return returnAssertType();
  }

  @Override
  public V startsWith(T... sequence) {
    LOGGER.log(Level.FINE, "Starts with: " + Arrays.toString(sequence));
    addSupplier(actual -> assertThat(actual).startsWith(sequence));
    return returnAssertType();
  }

  private static String iterableToString(Iterable<?> iterable) {
    List<String> iterableAsString = new LinkedList<>();
    iterable.forEach(value -> iterableAsString.add(value.toString()));

    return Arrays.toString(iterableAsString.toArray());
  }
}
