package io.github.henryssondaniel.teacup.core.assertion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import org.junit.jupiter.api.Test;

class StringAssertTest {
  private static final String ACTUAL = "";
  private static final String ERI = "eri";
  private static final CharSequence REGEX_FAIL = "var.?fy";
  private static final CharSequence REGEX_PASS = "ver.?fy";
  private static final String TEST = "test";

  @Test
  void verify() {
    Collection<String> strings = new ArrayList<>(6);
    strings.add(TEST);
    strings.add(TEST);
    strings.add(TEST);
    strings.add(TEST);
    strings.add(TEST);
    strings.add(TEST);

    var charSequence = "verify";

    Factory.createStringAssert()
        .contains(ERI)
        .containsIgnoringCase(ERI.toUpperCase(Locale.getDefault()))
        .containsOnlyOnce(ERI)
        .containsPattern(REGEX_PASS)
        .containsSequence(ERI)
        .containsSubsequence(ERI)
        .doesNotContain("erf")
        .doesNotContainPattern(REGEX_FAIL)
        .doesNotEndWith("ifi")
        .doesNotHaveSameClassAs(Integer.class)
        .doesNotMatch(REGEX_FAIL)
        .doesNotStartWith("var")
        .endsWith("ify")
        .hasSameClassAs(ACTUAL)
        .hasSameSizeAs(charSequence)
        .hasSameSizeAs(strings)
        .hasSameSizeAs("yfirev".toCharArray())
        .hasSize(6)
        .isEqualTo(charSequence)
        .isEqualToIgnoringCase(charSequence.toUpperCase(Locale.getDefault()))
        .isEqualToIgnoringNewLines(charSequence + System.lineSeparator())
        .isEqualToIgnoringWhitespace(charSequence + ' ')
        .isEqualToNormalizingNewlines(charSequence)
        .isEqualToNormalizingWhitespace(charSequence)
        .isGreaterThan(ACTUAL)
        .isGreaterThanOrEqualTo(ACTUAL)
        .isLessThan("wer")
        .isLessThanOrEqualTo("wer")
        .isNotEmpty()
        .isNotEqualTo(ACTUAL)
        .isNotEqualToIgnoringCase(ACTUAL)
        .isNotEqualToIgnoringWhitespace(ACTUAL)
        .isNotEqualToNormalizingWhitespace(ACTUAL)
        .isNotSameAs(ACTUAL)
        .isSameAs(charSequence)
        .isSubstringOf("verifyThis")
        .matches(REGEX_PASS)
        .startsWith("ver")
        .verify(charSequence);

    Factory.createStringAssert().isEmpty().isNullOrEmpty().verify(ACTUAL);

    Factory.createStringAssert()
        .isXmlEqualTo(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading></note>")
        .verify(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<note>"
                + "  <to>Tove</to>"
                + "  <from>Jani</from>"
                + "  <heading>Reminder</heading>"
                + "</note>");
  }
}
