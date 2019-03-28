package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractIterableAssert;

class IterableAssertImpl<T, U extends Iterable<? extends T>, V extends IterableAssert<T, U, V>>
    extends EnumerableAssertImpl<U, V> implements IterableAssert<T, U, V> {
  private static final Logger LOGGER = Logger.getLogger(IterableAssertImpl.class.getName());

  @Override
  public V contains(T... values) {
    LOGGER.log(Level.FINE, "Contains: " + Arrays.toString(values));
    addSupplier(() -> getAssert().contains(values));
    return getAssertType();
  }

  @Override
  public V containsAll(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains all: " + iterableToString(iterable));
    addSupplier(() -> getAssert().containsAll(iterable));
    return getAssertType();
  }

  @Override
  public V containsAnyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains any elements of: " + iterableToString(iterable));
    addSupplier(() -> getAssert().containsAnyElementsOf(iterable));
    return getAssertType();
  }

  @Override
  public V containsAnyOf(T... values) {
    LOGGER.log(Level.FINE, "Contains any of: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsAnyOf(values));
    return getAssertType();
  }

  @Override
  public V containsExactly(T... values) {
    LOGGER.log(Level.FINE, "Contains exactly: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsExactly(values));
    return getAssertType();
  }

  @Override
  public V containsExactlyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains exactly element of: " + iterableToString(iterable));
    addSupplier(() -> getAssert().containsExactlyElementsOf(iterable));
    return getAssertType();
  }

  @Override
  public V containsExactlyInAnyOrder(T... values) {
    LOGGER.log(Level.FINE, "Contains exactly in any order: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsExactlyInAnyOrder(values));
    return getAssertType();
  }

  @Override
  public V containsExactlyInAnyOrderElementsOf(Iterable<? extends T> values) {
    LOGGER.log(
        Level.FINE, "Contains exactly in any order elements of: " + iterableToString(values));
    addSupplier(() -> getAssert().containsExactlyInAnyOrderElementsOf(values));
    return getAssertType();
  }

  @Override
  public V containsNull() {
    LOGGER.log(Level.FINE, "Contains null");
    addSupplier(() -> getAssert().containsNull());
    return getAssertType();
  }

  @Override
  public V containsOnly(T... values) {
    LOGGER.log(Level.FINE, "Contains only: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsOnly(values));
    return getAssertType();
  }

  @Override
  public V containsOnlyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Contains only elements of: " + iterableToString(iterable));
    addSupplier(() -> getAssert().containsOnlyElementsOf(iterable));
    return getAssertType();
  }

  @Override
  public V containsOnlyNulls() {
    LOGGER.log(Level.FINE, "Contains only null");
    addSupplier(() -> getAssert().containsOnlyNulls());
    return getAssertType();
  }

  @Override
  public V containsOnlyOnce(T... values) {
    LOGGER.log(Level.FINE, "Contains only once: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsOnlyOnce(values));
    return getAssertType();
  }

  @Override
  public V containsSequence(T... sequence) {
    LOGGER.log(Level.FINE, "Contains sequence: " + Arrays.toString(sequence));
    addSupplier(() -> getAssert().containsSequence(sequence));
    return getAssertType();
  }

  @Override
  public V containsSequence(Iterable<? extends T> sequence) {
    LOGGER.log(Level.FINE, "Contains sequence: " + iterableToString(sequence));
    addSupplier(() -> getAssert().containsSequence(sequence));
    return getAssertType();
  }

  @Override
  public V containsSubsequence(T... subsequence) {
    LOGGER.log(Level.FINE, "Contains sub sequence: " + Arrays.toString(subsequence));
    addSupplier(() -> getAssert().containsSubsequence(subsequence));
    return getAssertType();
  }

  @Override
  public V containsSubsequence(Iterable<? extends T> subsequence) {
    LOGGER.log(Level.FINE, "Contains sub sequence: " + iterableToString(subsequence));
    addSupplier(() -> getAssert().containsSubsequence(subsequence));
    return getAssertType();
  }

  @Override
  public V doesNotContain(T... values) {
    LOGGER.log(Level.FINE, "Does not contain: " + Arrays.toString(values));
    addSupplier(() -> getAssert().doesNotContain(values));
    return getAssertType();
  }

  @Override
  public V doesNotContainAnyElementsOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Does not contain any elements of: " + iterableToString(iterable));
    addSupplier(() -> getAssert().doesNotContainAnyElementsOf(iterable));
    return getAssertType();
  }

  @Override
  public V doesNotContainNull() {
    LOGGER.log(Level.FINE, "Does not contain null");
    addSupplier(() -> getAssert().doesNotContainNull());
    return getAssertType();
  }

  @Override
  public V doesNotContainSequence(T... sequence) {
    LOGGER.log(Level.FINE, "Does not contain sequence: " + Arrays.toString(sequence));
    addSupplier(() -> getAssert().doesNotContainSequence(sequence));
    return getAssertType();
  }

  @Override
  public V doesNotContainSequence(Iterable<? extends T> sequence) {
    LOGGER.log(Level.FINE, "Does not contain sequence: " + iterableToString(sequence));
    addSupplier(() -> getAssert().doesNotContainSequence(sequence));
    return getAssertType();
  }

  @Override
  public V doesNotContainSubsequence(T... subsequence) {
    LOGGER.log(Level.FINE, "Does not contain sub sequence: " + Arrays.toString(subsequence));
    addSupplier(() -> getAssert().doesNotContainSubsequence(subsequence));
    return getAssertType();
  }

  @Override
  public V doesNotContainSubsequence(Iterable<? extends T> subsequence) {
    LOGGER.log(Level.FINE, "Does not contain sub sequence: " + iterableToString(subsequence));
    addSupplier(() -> getAssert().doesNotContainSubsequence(subsequence));
    return getAssertType();
  }

  @Override
  public V doesNotHaveAnyElementsOfTypes(Class<?>... types) {
    LOGGER.log(Level.FINE, "Does not have any elements of types: " + Arrays.toString(types));
    addSupplier(() -> getAssert().doesNotHaveAnyElementsOfTypes(types));
    return getAssertType();
  }

  @Override
  public V doesNotHaveDuplicates() {
    LOGGER.log(Level.FINE, "Does not have duplicates");
    addSupplier(() -> getAssert().doesNotHaveDuplicates());
    return getAssertType();
  }

  @Override
  public V endsWith(T... sequence) {
    LOGGER.log(Level.FINE, "Ends with: " + Arrays.toString(sequence));
    addSupplier(() -> getAssert().endsWith(sequence));
    return getAssertType();
  }

  @Override
  public V hasAtLeastOneElementOfType(Class<?> type) {
    LOGGER.log(Level.FINE, "Has at least one element of type: " + type.getName());
    addSupplier(() -> getAssert().hasAtLeastOneElementOfType(type));
    return getAssertType();
  }

  @Override
  public V hasOnlyElementsOfType(Class<?> type) {
    LOGGER.log(Level.FINE, "Has only elements of type " + type.getName());
    addSupplier(() -> getAssert().hasOnlyElementsOfType(type));
    return getAssertType();
  }

  @Override
  public V hasOnlyElementsOfTypes(Class<?>... types) {
    LOGGER.log(Level.FINE, "Has only elements of types: " + Arrays.toString(types));
    addSupplier(() -> getAssert().hasOnlyElementsOfTypes(types));
    return getAssertType();
  }

  @Override
  public V hasSameElementsAs(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Has same elements as: " + iterableToString(iterable));
    addSupplier(() -> getAssert().hasSameElementsAs(iterable));
    return getAssertType();
  }

  @Override
  public V isSubsetOf(T... values) {
    LOGGER.log(Level.FINE, "Is subset of: " + Arrays.toString(values));
    addSupplier(() -> getAssert().isSubsetOf(values));
    return getAssertType();
  }

  @Override
  public V isSubsetOf(Iterable<? extends T> iterable) {
    LOGGER.log(Level.FINE, "Is subset of: " + iterableToString(iterable));
    addSupplier(() -> getAssert().isSubsetOf(iterable));
    return getAssertType();
  }

  @Override
  public V startsWith(T... sequence) {
    LOGGER.log(Level.FINE, "Starts with: " + Arrays.toString(sequence));
    addSupplier(() -> getAssert().startsWith(sequence));
    return getAssertType();
  }

  @SuppressWarnings("unchecked")
  @Override
  AbstractIterableAssert<?, U, T, ?> getAssert() {
    return (AbstractIterableAssert<?, U, T, ?>) assertThat(getActual());
  }

  private static String iterableToString(Iterable<?> iterable) {
    List<String> iterableAsString = new LinkedList<>();
    iterable.forEach(value -> iterableAsString.add(value.toString()));

    return Arrays.toString(iterableAsString.toArray());
  }
}
