package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class AbstractIterableAssertTest {
  private static final Iterable<Integer> DIFFERENT = Arrays.asList(2, 3);
  private static final Iterable<Integer> NULL = Arrays.asList(1, null);
  private static final Iterable<Integer> ORDER_ASC = Arrays.asList(1, 2);
  private static final Iterable<Integer> ORDER_DESC = Arrays.asList(2, 1);

  private final TestGenericIterableAssert testGenericIterableAssert =
      new TestAbstractIterableAssert();

  @Test
  void contains() {
    testGenericIterableAssert.contains(1).verify(ORDER_ASC);
  }

  @Test
  void containsAll() {
    testGenericIterableAssert.containsAll(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void containsAllFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsAll(DIFFERENT).verify(ORDER_ASC));
  }

  @Test
  void containsAnyElementsOf() {
    testGenericIterableAssert.containsAnyElementsOf(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void containsAnyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .containsAnyElementsOf(Arrays.asList(3, 4))
                    .verify(ORDER_ASC));
  }

  @Test
  void containsAnyOf() {
    testGenericIterableAssert.containsAnyOf(1, 2).verify(ORDER_ASC);
  }

  @Test
  void containsAnyOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsAnyOf(3, 4).verify(ORDER_ASC));
  }

  @Test
  void containsExactly() {
    testGenericIterableAssert.containsExactly(1, 2).verify(ORDER_ASC);
  }

  @Test
  void containsExactlyElementsOf() {
    testGenericIterableAssert.containsExactlyElementsOf(ORDER_ASC).verify(ORDER_ASC);
  }

  @Test
  void containsExactlyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert.containsExactlyElementsOf(ORDER_DESC).verify(ORDER_ASC));
  }

  @Test
  void containsExactlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsExactly(2, 1).verify(ORDER_ASC));
  }

  @Test
  void containsExactlyInAnyOrder() {
    testGenericIterableAssert.containsExactlyInAnyOrder(2, 1).verify(ORDER_ASC);
  }

  @Test
  void containsExactlyInAnyOrderElementsOf() {
    testGenericIterableAssert.containsExactlyInAnyOrderElementsOf(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void containsExactlyInAnyOrderElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .containsExactlyInAnyOrderElementsOf(DIFFERENT)
                    .verify(ORDER_ASC));
  }

  @Test
  void containsExactlyInAnyOrderFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.containsExactlyInAnyOrder(3, 4).verify(ORDER_ASC));
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.contains(1, 3).verify(ORDER_ASC));
  }

  @Test
  void containsNull() {
    testGenericIterableAssert.containsNull().verify(NULL);
  }

  @Test
  void containsNullFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsNull().verify(ORDER_ASC));
  }

  @Test
  void containsOnly() {
    testGenericIterableAssert.containsOnly(1, 2).verify(ORDER_DESC);
  }

  @Test
  void containsOnlyElementsOf() {
    testGenericIterableAssert.containsOnlyElementsOf(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void containsOnlyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .containsOnlyElementsOf(Arrays.asList(3, 4))
                    .verify(ORDER_ASC));
  }

  @Test
  void containsOnlyFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsOnly(1).verify(ORDER_ASC));
  }

  @Test
  void containsOnlyNulls() {
    testGenericIterableAssert.containsOnlyNulls().verify(Arrays.asList(null, null));
  }

  @Test
  void containsOnlyNullsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsOnlyNulls().verify(NULL));
  }

  @Test
  void containsOnlyOnce() {
    testGenericIterableAssert.containsOnlyOnce(1, 2).verify(ORDER_ASC);
  }

  @Test
  void containsOnlyOnceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.containsOnlyOnce(1).verify(Arrays.asList(1, 1, 2)));
  }

  @Test
  void containsSequence() {
    testGenericIterableAssert.containsSequence(1, 2).verify(ORDER_ASC);
  }

  @Test
  void containsSequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsSequence(2, 1).verify(ORDER_ASC));
  }

  @Test
  void containsSequenceIterable() {
    testGenericIterableAssert.containsSequence(ORDER_ASC).verify(ORDER_ASC);
  }

  @Test
  void containsSequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsSequence(ORDER_DESC).verify(ORDER_ASC));
  }

  @Test
  void containsSubequenceIterable() {
    testGenericIterableAssert.containsSubsequence(ORDER_ASC).verify(ORDER_ASC);
  }

  @Test
  void containsSubsequence() {
    testGenericIterableAssert.containsSubsequence(1, 2).verify(ORDER_ASC);
  }

  @Test
  void containsSubsequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.containsSubsequence(2, 1).verify(ORDER_ASC));
  }

  @Test
  void containsSubsequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.containsSubsequence(ORDER_DESC).verify(ORDER_ASC));
  }

  @Test
  void doesNotContain() {
    testGenericIterableAssert.doesNotContain(3).verify(ORDER_ASC);
  }

  @Test
  void doesNotContainAnyElementsOf() {
    testGenericIterableAssert.doesNotContainAnyElementsOf(Arrays.asList(3, 4)).verify(ORDER_ASC);
  }

  @Test
  void doesNotContainAnyElementsOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .doesNotContainAnyElementsOf(ORDER_DESC)
                    .verify(ORDER_ASC));
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.doesNotContain(1).verify(ORDER_ASC));
  }

  @Test
  void doesNotContainNull() {
    testGenericIterableAssert.doesNotContainNull().verify(ORDER_ASC);
  }

  @Test
  void doesNotContainNullFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.doesNotContainNull().verify(NULL));
  }

  @Test
  void doesNotContainSequence() {
    testGenericIterableAssert.doesNotContainSequence(2, 1).verify(ORDER_ASC);
  }

  @Test
  void doesNotContainSequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.doesNotContainSequence(1, 2).verify(ORDER_ASC));
  }

  @Test
  void doesNotContainSequenceIterable() {
    testGenericIterableAssert.doesNotContainSequence(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void doesNotContainSequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.doesNotContainSequence(ORDER_ASC).verify(ORDER_ASC));
  }

  @Test
  void doesNotContainSubsequence() {
    testGenericIterableAssert.doesNotContainSubsequence(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void doesNotContainSubsequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.doesNotContainSubsequence(ORDER_ASC).verify(ORDER_ASC));
  }

  @Test
  void doesNotContainSubsequenceIterable() {
    testGenericIterableAssert.doesNotContainSubsequence(2, 1).verify(ORDER_ASC);
  }

  @Test
  void doesNotContainSubsequenceIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.doesNotContainSubsequence(1, 2).verify(ORDER_ASC));
  }

  @Test
  void doesNotHaveAnyElementsOfTypes() {
    testGenericIterableAssert.doesNotHaveAnyElementsOfTypes(String.class).verify(ORDER_ASC);
  }

  @Test
  void doesNotHaveAnyElementsOfTypesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .doesNotHaveAnyElementsOfTypes(Integer.class)
                    .verify(ORDER_ASC));
  }

  @Test
  void doesNotHaveDuplicates() {
    testGenericIterableAssert.doesNotHaveDuplicates().verify(ORDER_ASC);
  }

  @Test
  void doesNotHaveDuplicatesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.doesNotHaveDuplicates().verify(Arrays.asList(1, 1, 2)));
  }

  @Test
  void endsWith() {
    testGenericIterableAssert.endsWith(new Integer[] {2}).verify(ORDER_ASC);
  }

  @Test
  void endsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.endsWith(new Integer[1]).verify(ORDER_ASC));
  }

  @Test
  void hasAtLeastOneElementOfType() {
    testGenericIterableAssert.hasAtLeastOneElementOfType(Integer.class).verify(ORDER_ASC);
  }

  @Test
  void hasAtLeastOneElementOfTypeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .hasAtLeastOneElementOfType(String.class)
                    .verify(ORDER_ASC));
  }

  @Test
  void hasOnlyElementsOfType() {
    testGenericIterableAssert.hasOnlyElementsOfType(Integer.class).verify(ORDER_ASC);
  }

  @Test
  void hasOnlyElementsOfTypeFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testGenericIterableAssert.hasOnlyElementsOfType(String.class).verify(ORDER_ASC));
  }

  @Test
  void hasOnlyElementsOfTypes() {
    testGenericIterableAssert.hasOnlyElementsOfTypes(Integer.class, String.class).verify(ORDER_ASC);
  }

  @Test
  void hasOnlyElementsOfTypesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testGenericIterableAssert
                    .hasOnlyElementsOfTypes(Double.class, String.class)
                    .verify(ORDER_ASC));
  }

  @Test
  void hasSameElementsAs() {
    testGenericIterableAssert.hasSameElementsAs(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void hasSameElementsAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.hasSameElementsAs(DIFFERENT).verify(ORDER_ASC));
  }

  @Test
  void isSubsetOf() {
    testGenericIterableAssert.isSubsetOf(1, 2).verify(ORDER_ASC);
  }

  @Test
  void isSubsetOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.isSubsetOf(1, 2).verify(DIFFERENT));
  }

  @Test
  void isSubsetOfIterable() {
    testGenericIterableAssert.isSubsetOf(ORDER_DESC).verify(ORDER_ASC);
  }

  @Test
  void isSubsetOfIterableFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.isSubsetOf(DIFFERENT).verify(ORDER_ASC));
  }

  @Test
  void startsWith() {
    testGenericIterableAssert.startsWith(new Integer[] {1}).verify(ORDER_ASC);
  }

  @Test
  void startsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testGenericIterableAssert.startsWith(new Integer[2]).verify(ORDER_ASC));
  }

  private interface TestGenericIterableAssert
      extends GenericIterableAssert<Integer, Iterable<Integer>, TestGenericIterableAssert> {}

  private static final class TestAbstractIterableAssert
      extends AbstractIterableAssert<Integer, Iterable<Integer>, TestGenericIterableAssert>
      implements TestGenericIterableAssert {}
}
