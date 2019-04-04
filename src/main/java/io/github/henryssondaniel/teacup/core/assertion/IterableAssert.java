package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Iterable assertions.
 *
 * @param <T> the type
 * @param <U> the iterable type
 * @param <V> the iterable assert type
 * @since 1.0
 */
public interface IterableAssert<
        T, U extends Iterable<? extends T>, V extends IterableAssert<T, U, V>>
    extends EnumerableAssert<U, V> {
  /**
   * Verifies that the iterable contains the given values, in any order.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V contains(T... values);

  /**
   * Verifies that the iterable contains all the elements of the given iterable, in any order.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V containsAll(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable contains any of the elements of the given iterable.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V containsAnyElementsOf(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable contains any of the given values.
   *
   * @param values the value
   * @return the iterable assert
   * @since 1.0
   */
  V containsAnyOf(T... values);

  /**
   * Verifies that the iterable contains exactly all the given values.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V containsExactly(T... values);

  /**
   * Verifies that the iterable contains exactly the elements of the given iterable.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V containsExactlyElementsOf(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable contains exactly all the given values, in any order.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V containsExactlyInAnyOrder(T... values);

  /**
   * Verifies that the iterable contains exactly all of the elements of the given iterable, in any
   * order.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V containsExactlyInAnyOrderElementsOf(Iterable<? extends T> values);

  /**
   * Verifies that the iterable contains at least one null element.
   *
   * @return the iterable assert
   * @since 1.0
   */
  V containsNull();

  /**
   * Verifies that the iterable only contains the given values.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V containsOnly(T... values);

  /**
   * Verifies that the iterable only contains the elements of the given iterable.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V containsOnlyElementsOf(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable only contains null element.
   *
   * @return the iterable assert
   * @since 1.0
   */
  V containsOnlyNulls();

  /**
   * Verifies that the iterable only contains the given values once.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V containsOnlyOnce(T... values);

  /**
   * Verifies that the iterable contains the given sequence.
   *
   * @param sequence the sequence
   * @return the iterable assert
   * @since 1.0
   */
  V containsSequence(T... sequence);

  /**
   * Verifies that the iterable contains the sequence of the given iterable.
   *
   * @param sequence the sequence
   * @return the iterable assert
   * @since 1.0
   */
  V containsSequence(Iterable<? extends T> sequence);

  /**
   * Verifies that the iterable contains the given subsequence.
   *
   * @param subsequence the subsequence
   * @return the iterable assert
   * @since 1.0
   */
  V containsSubsequence(T... subsequence);

  /**
   * Verifies that the iterable contains the subsequence of the given iterable.
   *
   * @param subsequence the subsequence
   * @return the iterable assert
   * @since 1.0
   */
  V containsSubsequence(Iterable<? extends T> subsequence);

  /**
   * Verifies that the iterable does not contain the given values.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContain(T... values);

  /**
   * Verifies that the iterable does not contain any of the elements of the given iterable.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContainAnyElementsOf(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable does not contain any null element.
   *
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContainNull();

  /**
   * Verifies that the iterable does not contain the given sequence.
   *
   * @param sequence the sequence
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContainSequence(T... sequence);

  /**
   * Verifies that the iterable does not contain the sequence of the given iterable.
   *
   * @param sequence the sequence
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContainSequence(Iterable<? extends T> sequence);

  /**
   * Verifies that the iterable does not contain the given subsequence.
   *
   * @param subsequence the subsequence
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContainSubsequence(T... subsequence);

  /**
   * Verifies that the iterable does not contain the subsequence of the given iterable.
   *
   * @param subsequence the subsequence
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotContainSubsequence(Iterable<? extends T> subsequence);

  /**
   * Verifies that the iterable does not have any elements of the given types.
   *
   * @param types the types
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotHaveAnyElementsOfTypes(Class<?>... types);

  /**
   * Verifies that the iterable does not have duplicates.
   *
   * @return the iterable assert
   * @since 1.0
   */
  V doesNotHaveDuplicates();

  /**
   * Verifies that the iterable ends with the given sequence.
   *
   * @param sequence the sequence
   * @return the iterable assert
   * @since 1.0
   */
  V endsWith(T... sequence);

  /**
   * Verifies that the iterable has at least one element of the given type.
   *
   * @param type the type
   * @return the iterable assert
   * @since 1.0
   */
  V hasAtLeastOneElementOfType(Class<?> type);

  /**
   * Verifies that the iterable has only elements of the given type.
   *
   * @param type type
   * @return the iterable assert
   * @since 1.0
   */
  V hasOnlyElementsOfType(Class<?> type);

  /**
   * Verifies that the iterable has only elements of the given types.
   *
   * @param types the types
   * @return the iterable assert
   * @since 1.0
   */
  V hasOnlyElementsOfTypes(Class<?>... types);

  /**
   * Verifies that the iterable has same elements as the given iterable.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V hasSameElementsAs(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable is a subset of the given values.
   *
   * @param values the values
   * @return the iterable assert
   * @since 1.0
   */
  V isSubsetOf(T... values);

  /**
   * Verifies that the iterable is a subset of the given iterable.
   *
   * @param iterable the iterable
   * @return the iterable assert
   * @since 1.0
   */
  V isSubsetOf(Iterable<? extends T> iterable);

  /**
   * Verifies that the iterable starts with the given sequence.
   *
   * @param sequence the sequence
   * @return the iterable assert
   * @since 1.0
   */
  V startsWith(T... sequence);
}
