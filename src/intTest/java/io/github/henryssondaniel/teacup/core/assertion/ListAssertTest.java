package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListAssertTest {
  private static final List<String> ACTUAL = new ArrayList<>(0);
  private static final String ALWAYS = "always";
  private static final String FUN = "fun";
  private static final String IS = "is";
  private static final String NEVER = "never";
  private static final String TEST = "test";

  @Test
  void verify() {
    List<String> strings = new ArrayList<>(3);
    strings.add(TEST);
    strings.add(IS);
    strings.add(FUN);

    Collection<String> stringsExtended = new ArrayList<>(strings);
    stringsExtended.add(ALWAYS);

    Iterable<String> singletonList = Collections.singletonList(NEVER);

    Factory.createListAssert()
        .contains(TEST, IS, FUN)
        .contains(IS, 1)
        .containsAll(strings)
        .containsAnyElementsOf(strings)
        .containsAnyOf(TEST, IS, ALWAYS, FUN)
        .containsExactly(TEST, IS, FUN)
        .containsExactlyElementsOf(strings)
        .containsExactlyInAnyOrder(TEST, FUN, IS)
        .containsExactlyInAnyOrderElementsOf(strings)
        .containsSubsequence(TEST, IS)
        .containsSubsequence(Collections.singletonList(TEST))
        .containsOnly(TEST, IS, FUN)
        .containsOnlyOnce(TEST)
        .containsSequence(TEST, IS)
        .containsSequence(strings)
        .doesNotContain("not")
        .doesNotContain(FUN, 0)
        .doesNotContainAnyElementsOf(Collections.singletonList(1))
        .doesNotContainNull()
        .doesNotContainSequence(TEST, FUN)
        .doesNotContainSequence(singletonList)
        .doesNotContainSubsequence(TEST, NEVER)
        .doesNotContainSubsequence(singletonList)
        .doesNotHaveAnyElementsOfTypes(Integer.class)
        .doesNotHaveDuplicates()
        .doesNotHaveSameClassAs(Integer.class)
        .endsWith(IS, FUN)
        .hasAtLeastOneElementOfType(String.class)
        .hasOnlyElementsOfType(String.class)
        .hasOnlyElementsOfTypes(String.class)
        .hasSameClassAs(ACTUAL)
        .hasSameElementsAs(strings)
        .hasSameSizeAs(new int[] {1, 2, 3})
        .hasSameSizeAs(strings)
        .hasSize(3)
        .isEqualTo(strings)
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(strings)
        .isSubsetOf(TEST, IS, FUN, ALWAYS)
        .isSubsetOf(stringsExtended)
        .startsWith(TEST, IS)
        .verify(strings);

    Factory.createListAssert().isEmpty().isNullOrEmpty().verify(Collections.emptyList());

    Factory.createListAssert()
        .containsNull()
        .containsOnlyNulls()
        .verify(Collections.singletonList(null));
  }
}
