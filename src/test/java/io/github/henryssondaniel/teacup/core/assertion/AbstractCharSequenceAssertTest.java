package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Locale;
import org.junit.jupiter.api.Test;

class AbstractCharSequenceAssertTest {
  private static final String REGEX = ".*en.*";
  private static final String SEQUENCE = "sequence";
  private static final String SEQUENCE_END = "nce";
  private static final String SEQUENCE_LONG = "sequencelongerSequence";
  private static final String SEQUENCE_SPACE = "sequence ";
  private static final String SEQUENCE_START = "seq";
  private static final CharSequence XML =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?><note><to>Tove</to><from>Jani</from><heading>Reminder</heading></note>";

  private final TestGenericCharSequenceAssert testAbstractCharSequenceAssert =
      new TestAbstractCharSequenceAssert();

  @Test
  void contains() {
    testAbstractCharSequenceAssert.contains(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testAbstractCharSequenceAssert.contains(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsIgnoringCase() {
    testAbstractCharSequenceAssert
        .containsIgnoringCase(SEQUENCE.toUpperCase(Locale.getDefault()))
        .verify(SEQUENCE_LONG);
  }

  @Test
  void containsIgnoringCaseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .containsIgnoringCase(SEQUENCE_LONG)
                    .verify(SEQUENCE));
  }

  @Test
  void containsOnlyOnce() {
    testAbstractCharSequenceAssert.containsOnlyOnce(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsOnlyOnceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testAbstractCharSequenceAssert.containsOnlyOnce("e").verify(SEQUENCE));
  }

  @Test
  void containsPattern() {
    testAbstractCharSequenceAssert.containsPattern(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsPatternFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.containsPattern(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsSequence() {
    testAbstractCharSequenceAssert.containsSequence(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsSequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.containsSequence(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void containsSubsequence() {
    testAbstractCharSequenceAssert.containsSubsequence(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void containsSubsequenceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert.containsSubsequence(SEQUENCE_LONG).verify(SEQUENCE));
  }

  @Test
  void doesNotContain() {
    testAbstractCharSequenceAssert.doesNotContain(SEQUENCE_LONG).verify(SEQUENCE);
  }

  @Test
  void doesNotContainFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.doesNotContain(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void doesNotContainPattern() {
    testAbstractCharSequenceAssert.doesNotContainPattern(SEQUENCE_LONG).verify(SEQUENCE);
  }

  @Test
  void doesNotContainPatternFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .doesNotContainPattern(SEQUENCE)
                    .verify(SEQUENCE_LONG));
  }

  @Test
  void doesNotEndWith() {
    testAbstractCharSequenceAssert.doesNotEndWith(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void doesNotEndWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.doesNotEndWith(SEQUENCE_END).verify(SEQUENCE));
  }

  @Test
  void doesNotMatch() {
    testAbstractCharSequenceAssert.doesNotMatch(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void doesNotMatchFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testAbstractCharSequenceAssert.doesNotMatch(REGEX).verify(SEQUENCE));
  }

  @Test
  void doesNotStartWith() {
    testAbstractCharSequenceAssert.doesNotStartWith(SEQUENCE_LONG).verify(SEQUENCE);
  }

  @Test
  void doesNotStartWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.doesNotStartWith(SEQUENCE).verify(SEQUENCE_LONG));
  }

  @Test
  void endsWith() {
    testAbstractCharSequenceAssert.endsWith(SEQUENCE_END).verify(SEQUENCE);
  }

  @Test
  void endsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testAbstractCharSequenceAssert.endsWith(SEQUENCE).verify(SEQUENCE_END));
  }

  @Test
  void hasSameSizeAs() {
    testAbstractCharSequenceAssert.hasSameSizeAs("abcdefgh").verify(SEQUENCE);
  }

  @Test
  void hasSameSizeAsFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.hasSameSizeAs("abcdefghi").verify(SEQUENCE));
  }

  @Test
  void isEqualToIgnoringCase() {
    testAbstractCharSequenceAssert
        .isEqualToIgnoringCase(SEQUENCE.toLowerCase(Locale.getDefault()))
        .verify(SEQUENCE);
  }

  @Test
  void isEqualToIgnoringCaseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isEqualToIgnoringCase(SEQUENCE)
                    .verify(SEQUENCE_LONG));
  }

  @Test
  void isEqualToIgnoringNewLines() {
    testAbstractCharSequenceAssert
        .isEqualToIgnoringNewLines(SEQUENCE)
        .verify(SEQUENCE + System.lineSeparator());
  }

  @Test
  void isEqualToIgnoringNewLinesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isEqualToIgnoringNewLines(SEQUENCE)
                    .verify(SEQUENCE_LONG));
  }

  @Test
  void isEqualToIgnoringWhitespace() {
    testAbstractCharSequenceAssert.isEqualToIgnoringWhitespace(SEQUENCE).verify(SEQUENCE_SPACE);
  }

  @Test
  void isEqualToIgnoringWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isEqualToIgnoringWhitespace(SEQUENCE_LONG)
                    .verify(SEQUENCE_SPACE));
  }

  @Test
  void isEqualToNormalizingNewlines() {
    testAbstractCharSequenceAssert.isEqualToNormalizingNewlines(SEQUENCE).verify(SEQUENCE);
  }

  @Test
  void isEqualToNormalizingNewlinesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isEqualToNormalizingNewlines(SEQUENCE)
                    .verify(SEQUENCE_LONG));
  }

  @Test
  void isEqualToNormalizingWhitespace() {
    testAbstractCharSequenceAssert.isEqualToNormalizingWhitespace(SEQUENCE).verify(SEQUENCE);
  }

  @Test
  void isEqualToNormalizingWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isEqualToNormalizingWhitespace(SEQUENCE)
                    .verify(SEQUENCE_LONG));
  }

  @Test
  void isNotEqualToIgnoringCase() {
    testAbstractCharSequenceAssert.isNotEqualToIgnoringCase(SEQUENCE).verify(SEQUENCE_LONG);
  }

  @Test
  void isNotEqualToIgnoringCaseFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isNotEqualToIgnoringCase(SEQUENCE)
                    .verify(SEQUENCE.toLowerCase(Locale.getDefault())));
  }

  @Test
  void isNotEqualToIgnoringWhitespace() {
    testAbstractCharSequenceAssert
        .isNotEqualToIgnoringWhitespace(SEQUENCE_SPACE)
        .verify(SEQUENCE_LONG);
  }

  @Test
  void isNotEqualToIgnoringWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isNotEqualToIgnoringWhitespace(SEQUENCE_SPACE)
                    .verify(SEQUENCE));
  }

  @Test
  void isNotEqualToNormalizingWhitespace() {
    testAbstractCharSequenceAssert
        .isNotEqualToNormalizingWhitespace(SEQUENCE)
        .verify(SEQUENCE_LONG);
  }

  @Test
  void isNotEqualToNormalizingWhitespaceFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () ->
                testAbstractCharSequenceAssert
                    .isNotEqualToNormalizingWhitespace(SEQUENCE)
                    .verify(SEQUENCE));
  }

  @Test
  void isSubstringOf() {
    testAbstractCharSequenceAssert.isSubstringOf(SEQUENCE_LONG).verify(SEQUENCE_END);
  }

  @Test
  void isSubstringOfFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.isSubstringOf(SEQUENCE_END).verify(SEQUENCE_LONG));
  }

  @Test
  void isXmlEqualTo() {
    testAbstractCharSequenceAssert
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
                testAbstractCharSequenceAssert
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
    testAbstractCharSequenceAssert.matches(REGEX).verify(SEQUENCE);
  }

  @Test
  void matchesFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(() -> testAbstractCharSequenceAssert.matches(SEQUENCE).verify(REGEX));
  }

  @Test
  void startsWith() {
    testAbstractCharSequenceAssert.startsWith(SEQUENCE_START).verify(SEQUENCE);
  }

  @Test
  void startsWithFail() {
    assertThatExceptionOfType(AssertionError.class)
        .isThrownBy(
            () -> testAbstractCharSequenceAssert.startsWith(SEQUENCE).verify(SEQUENCE_START));
  }

  private interface TestGenericCharSequenceAssert
      extends GenericCharSequenceAssert<String, TestGenericCharSequenceAssert> {}

  private static final class TestAbstractCharSequenceAssert
      extends AbstractCharSequenceAssert<String, TestGenericCharSequenceAssert>
      implements TestGenericCharSequenceAssert {}
}
