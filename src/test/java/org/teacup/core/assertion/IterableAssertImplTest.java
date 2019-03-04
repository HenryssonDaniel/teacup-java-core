package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class IterableAssertImplTest {
  private static final List<Integer> LIST_DIFFERENT = Arrays.asList(2, 3);
  private static final List<Integer> LIST_NULL = Arrays.asList(1, null);
  private static final List<Integer> LIST_ORDER_ASC = Arrays.asList(1, 2);
  private static final List<Integer> LIST_ORDER_DESC = Arrays.asList(2, 1);

  private final IterableAssert<Integer, List<Integer>, ?> iterableAssert =
      new IterableAssertImpl<>();

  @Test
  void contains() {
    iterableAssert.contains(1).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsAll() {
    iterableAssert.containsAll(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsAllFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsAll(LIST_DIFFERENT).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsAnyElementsOf() {
    iterableAssert.containsAnyElementsOf(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsAnyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.containsAnyElementsOf(Arrays.asList(3, 4)).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsAnyOf() {
    iterableAssert.containsAnyOf(1, 2).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsAnyOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsAnyOf(3, 4).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsExactly() {
    iterableAssert.containsExactly(1, 2).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsExactlyElementsOf() {
    iterableAssert.containsExactlyElementsOf(LIST_ORDER_ASC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsExactlyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.containsExactlyElementsOf(LIST_ORDER_DESC).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsExactlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsExactly(2, 1).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsExactlyInAnyOrder() {
    iterableAssert.containsExactlyInAnyOrder(2, 1).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsExactlyInAnyOrderElementsOf() {
    iterableAssert.containsExactlyInAnyOrderElementsOf(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsExactlyInAnyOrderElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                iterableAssert
                    .containsExactlyInAnyOrderElementsOf(LIST_DIFFERENT)
                    .verify(LIST_ORDER_ASC));
  }

  @Test
  void containsExactlyInAnyOrderFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsExactlyInAnyOrder(3, 4).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.contains(1, 3).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsNull() {
    iterableAssert.containsNull().verify(LIST_NULL);
  }

  @Test
  void containsNullFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsNull().verify(LIST_ORDER_ASC));
  }

  @Test
  void containsOnly() {
    iterableAssert.containsOnly(1, 2).verify(LIST_ORDER_DESC);
  }

  @Test
  void containsOnlyElementsOf() {
    iterableAssert.containsOnlyElementsOf(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsOnlyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                iterableAssert.containsOnlyElementsOf(Arrays.asList(3, 4)).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsOnlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsOnly(1).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsOnlyNulls() {
    iterableAssert.containsOnlyNulls().verify(Arrays.asList(null, null));
  }

  @Test
  void containsOnlyNullsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsOnlyNulls().verify(LIST_NULL));
  }

  @Test
  void containsOnlyOnce() {
    iterableAssert.containsOnlyOnce(1, 2).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsOnlyOnceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsOnlyOnce(1).verify(Arrays.asList(1, 1, 2)));
  }

  @Test
  void containsSequence() {
    iterableAssert.containsSequence(1, 2).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsSequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsSequence(2, 1).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsSequenceIterable() {
    iterableAssert.containsSequence(LIST_ORDER_ASC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsSequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsSequence(LIST_ORDER_DESC).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsSubequenceIterable() {
    iterableAssert.containsSubsequence(LIST_ORDER_ASC).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsSubsequence() {
    iterableAssert.containsSubsequence(1, 2).verify(LIST_ORDER_ASC);
  }

  @Test
  void containsSubsequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.containsSubsequence(2, 1).verify(LIST_ORDER_ASC));
  }

  @Test
  void containsSubsequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.containsSubsequence(LIST_ORDER_DESC).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotContain() {
    iterableAssert.doesNotContain(3).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainAnyElementsOf() {
    iterableAssert.doesNotContainAnyElementsOf(Arrays.asList(3, 4)).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainAnyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                iterableAssert.doesNotContainAnyElementsOf(LIST_ORDER_DESC).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.doesNotContain(1).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotContainNull() {
    iterableAssert.doesNotContainNull().verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainNullFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.doesNotContainNull().verify(LIST_NULL));
  }

  @Test
  void doesNotContainSequence() {
    iterableAssert.doesNotContainSequence(2, 1).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainSequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.doesNotContainSequence(1, 2).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotContainSequenceIterable() {
    iterableAssert.doesNotContainSequence(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainSequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.doesNotContainSequence(LIST_ORDER_ASC).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotContainSubsequence() {
    iterableAssert.doesNotContainSubsequence(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainSubsequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.doesNotContainSubsequence(LIST_ORDER_ASC).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotContainSubsequenceIterable() {
    iterableAssert.doesNotContainSubsequence(2, 1).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotContainSubsequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.doesNotContainSubsequence(1, 2).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotHaveAnyElementsOfTypes() {
    iterableAssert.doesNotHaveAnyElementsOfTypes(String.class).verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotHaveAnyElementsOfTypesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                iterableAssert.doesNotHaveAnyElementsOfTypes(Integer.class).verify(LIST_ORDER_ASC));
  }

  @Test
  void doesNotHaveDuplicates() {
    iterableAssert.doesNotHaveDuplicates().verify(LIST_ORDER_ASC);
  }

  @Test
  void doesNotHaveDuplicatesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.doesNotHaveDuplicates().verify(Arrays.asList(1, 1, 2)));
  }

  @Test
  void endsWith() {
    iterableAssert.endsWith(new Integer[] {2}).verify(LIST_ORDER_ASC);
  }

  @Test
  void endsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.endsWith(new Integer[1]).verify(LIST_ORDER_ASC));
  }

  @Test
  void hasAtLeastOneElementOfType() {
    iterableAssert.hasAtLeastOneElementOfType(Integer.class).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasAtLeastOneElementOfTypeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.hasAtLeastOneElementOfType(String.class).verify(LIST_ORDER_ASC));
  }

  @Test
  void hasOnlyElementsOfType() {
    iterableAssert.hasOnlyElementsOfType(Integer.class).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasOnlyElementsOfTypeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> iterableAssert.hasOnlyElementsOfType(String.class).verify(LIST_ORDER_ASC));
  }

  @Test
  void hasOnlyElementsOfTypes() {
    iterableAssert.hasOnlyElementsOfTypes(Integer.class, String.class).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasOnlyElementsOfTypesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                iterableAssert
                    .hasOnlyElementsOfTypes(Double.class, String.class)
                    .verify(LIST_ORDER_ASC));
  }

  @Test
  void hasSameElementsAs() {
    iterableAssert.hasSameElementsAs(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasSameElementsAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.hasSameElementsAs(LIST_DIFFERENT).verify(LIST_ORDER_ASC));
  }

  @Test
  void hasSameSizeAs() {
    iterableAssert.hasSameSizeAs(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasSameSizeAsArray() {
    iterableAssert.hasSameSizeAs(new Integer[] {2, 3}).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasSameSizeAsArrayFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.hasSameSizeAs(new Integer[] {1}).verify(LIST_ORDER_ASC));
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                iterableAssert.hasSameSizeAs(Collections.singletonList(1)).verify(LIST_ORDER_ASC));
  }

  @Test
  void hasSize() {
    iterableAssert.hasSize(2).verify(LIST_ORDER_ASC);
  }

  @Test
  void hasSizeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.hasSize(1).verify(LIST_ORDER_ASC));
  }

  @Test
  void isEmpty() {
    iterableAssert.isEmpty().verify(Collections.emptyList());
  }

  @Test
  void isEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.isEmpty().verify(LIST_ORDER_ASC));
  }

  @Test
  void isNotEmpty() {
    iterableAssert.isNotEmpty().verify(LIST_ORDER_ASC);
  }

  @Test
  void isNotEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.isNotEmpty().verify(Collections.emptyList()));
  }

  @Test
  void isNullOrEmpty() {
    iterableAssert.isNullOrEmpty().verify(null);
  }

  @Test
  void isNullOrEmptyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.isNullOrEmpty().verify(LIST_ORDER_ASC));
  }

  @Test
  void isSubsetOf() {
    iterableAssert.isSubsetOf(1, 2).verify(LIST_ORDER_ASC);
  }

  @Test
  void isSubsetOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.isSubsetOf(1, 2).verify(LIST_DIFFERENT));
  }

  @Test
  void isSubsetOfIterable() {
    iterableAssert.isSubsetOf(LIST_ORDER_DESC).verify(LIST_ORDER_ASC);
  }

  @Test
  void isSubsetOfIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.isSubsetOf(LIST_DIFFERENT).verify(LIST_ORDER_ASC));
  }

  @Test
  void startsWith() {
    iterableAssert.startsWith(new Integer[] {1}).verify(LIST_ORDER_ASC);
  }

  @Test
  void startsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> iterableAssert.startsWith(new Integer[2]).verify(LIST_ORDER_ASC));
  }
}
