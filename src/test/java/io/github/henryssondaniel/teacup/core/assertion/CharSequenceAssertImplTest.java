package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Locale;
import org.junit.jupiter.api.Test;

class CharSequenceAssertImplTest {
  private static final String REGEX = ".*en.*";
  private static final String SEQUENCE = "sequence";
  private static final String SEQUENCE_END = "nce";
  private static final String SEQUENCE_LONG = "sequencelongerSequence";
  private static final String SEQUENCE_SPACE = "sequence ";
  private static final String SEQUENCE_START = "seq";
  private static final CharSequence XML =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading></note>";

  private final CharSequenceAssert<String, ?> charSequenceAssert = new CharSequenceAssertImpl<>();

  @Test
  void contains() {
    charSequenceAssert.contains(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.contains(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsIgnoringCase() {
    charSequenceAssert
        .containsIgnoringCase(SEQUENCE.toUpperCase(Locale.getDefault()))
        .verify(SEQUENCE_LONG);
  }

  @Test
  void containsIgnoringCaseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.containsIgnoringCase(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsOnlyOnce() {
    charSequenceAssert.containsOnlyOnce(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsOnlyOnceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.containsOnlyOnce("e").verify(SEQUENCE));
  }

  @Test
  void containsPattern() {
    charSequenceAssert.containsPattern(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsPatternFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.containsPattern(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsSequence() {
    charSequenceAssert.containsSequence(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsSequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.containsSequence(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsSubsequence() {
    charSequenceAssert.containsSubsequence(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsSubsequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.containsSubsequence(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void doesNotContain() {
    charSequenceAssert.doesNotContain(SEQUENCE_LONG).verify(SEQUENCE);
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.doesNotContain(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void doesNotContainPattern() {
    charSequenceAssert.doesNotContainPattern(SEQUENCE_LONG).verify(SEQUENCE);
  }

  @Test
  void doesNotContainPatternFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.doesNotContainPattern(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void doesNotEndWith() {
    charSequenceAssert.doesNotEndWith(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void doesNotEndWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.doesNotEndWith(SEQUENCE_END).verify(SEQUENCE));
  }

  @Test
  void doesNotMatch() {
    charSequenceAssert.doesNotMatch(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void doesNotMatchFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.doesNotMatch(REGEX).verify(SEQUENCE));
  }

  @Test
  void doesNotStartWith() {
    charSequenceAssert.doesNotStartWith(SEQUENCE_LONG).verify(SEQUENCE);
  }

  @Test
  void doesNotStartWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.doesNotStartWith(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void endsWith() {
    charSequenceAssert.endsWith(SEQUENCE_END).verify(SEQUENCE);
  }

  @Test
  void endsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.endsWith(SEQUENCE).verify(SEQUENCE_END));
  }

  @Test
  void hasSameSizeAs() {
    charSequenceAssert.hasSameSizeAs("abcdefgh").verify(SEQUENCE);
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.hasSameSizeAs("abcdefghi").verify(SEQUENCE));
  }

  @Test
  void isEqualToIgnoringCase() {
    charSequenceAssert
        .isEqualToIgnoringCase(SEQUENCE.toLowerCase(Locale.getDefault()))
        .verify(SEQUENCE);
  }

  @Test
  void isEqualToIgnoringCaseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.isEqualToIgnoringCase(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void isEqualToIgnoringNewLines() {
    charSequenceAssert
        .isEqualToIgnoringNewLines(SEQUENCE)
        .verify(SEQUENCE + System.lineSeparator());
  }

  @Test
  void isEqualToIgnoringNewLinesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> charSequenceAssert.isEqualToIgnoringNewLines(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void isEqualToIgnoringWhitespace() {
    charSequenceAssert.isEqualToIgnoringWhitespace(SEQUENCE).verify(SEQUENCE_SPACE);
  }

  @Test
  void isEqualToIgnoringWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                charSequenceAssert
                    .isEqualToIgnoringWhitespace(SEQUENCE_LONG)
                    .verify(SEQUENCE_SPACE));
  }

  @Test
  void isEqualToNormalizingNewlines() {
    charSequenceAssert.isEqualToNormalizingNewlines(SEQUENCE).verify(SEQUENCE);
  }

  @Test
  void isEqualToNormalizingNewlinesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> charSequenceAssert.isEqualToNormalizingNewlines(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void isEqualToNormalizingWhitespace() {
    charSequenceAssert.isEqualToNormalizingWhitespace(SEQUENCE).verify(SEQUENCE);
  }

  @Test
  void isEqualToNormalizingWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                charSequenceAssert.isEqualToNormalizingWhitespace(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void isNotEqualToIgnoringCase() {
    charSequenceAssert.isNotEqualToIgnoringCase(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void isNotEqualToIgnoringCaseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                charSequenceAssert
                    .isNotEqualToIgnoringCase(SEQUENCE)
                    .verify(SEQUENCE.toLowerCase(Locale.getDefault())));
  }

  @Test
  void isNotEqualToIgnoringWhitespace() {
    charSequenceAssert.isNotEqualToIgnoringWhitespace(SEQUENCE_SPACE).verify(SEQUENCE_LONG);
  }

  @Test
  void isNotEqualToIgnoringWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                charSequenceAssert.isNotEqualToIgnoringWhitespace(SEQUENCE_SPACE).verify(SEQUENCE));
  }

  @Test
  void isNotEqualToNormalizingWhitespace() {
    charSequenceAssert.isNotEqualToNormalizingWhitespace(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void isNotEqualToNormalizingWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> charSequenceAssert.isNotEqualToNormalizingWhitespace(SEQUENCE).verify(SEQUENCE));
  }

  @Test
  void isSubstringOf() {
    charSequenceAssert.isSubstringOf(SEQUENCE_LONG).verify(SEQUENCE_END);
  }

  @Test
  void isSubstringOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.isSubstringOf(SEQUENCE_END).verify(SEQUENCE_LONG));
  }

  @Test
  void isXmlEqualTo() {
    charSequenceAssert
        .isXmlEqualTo(XML)
        .verify(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<note>"
                + "  <to>Tove</to>"
                + "  <from>Jani</from>"
                + "  <heading>Reminder</heading>"
                + "</note>");
  }

  @Test
  void isXmlEqualToFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                charSequenceAssert
                    .isXmlEqualTo(XML)
                    .verify(
                        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                            + "<note>"
                            + "  <from>Jani</from>"
                            + "  <heading>Reminder</heading>"
                            + "</note>"));
  }

  @Test
  void matches() {
    charSequenceAssert.matches(REGEX).verify(SEQUENCE);
  }

  @Test
  void matchesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.matches(SEQUENCE).verify(REGEX));
  }

  @Test
  void startsWith() {
    charSequenceAssert.startsWith(SEQUENCE_START).verify(SEQUENCE);
  }

  @Test
  void startsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> charSequenceAssert.startsWith(SEQUENCE).verify(SEQUENCE_START));
  }
}
