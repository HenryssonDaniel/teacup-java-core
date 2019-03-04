package org.teacup.core.assertion;

/**
 * Char sequence assertions.
 *
 * @param <T> the char sequence type
 * @param <U> the char sequence assert type
 * @since 1.0
 */
public interface CharSequenceAssert<T extends CharSequence, U extends CharSequenceAssert<T, U>>
    extends EnumerableAssert<U>, ObjectAssert<T, U> {
  /**
   * Verifies that the CharSequence contains the values.
   *
   * @param values the values
   * @return the char sequence assert
   */
  U contains(CharSequence... values);

  /**
   * Verifies that the CharSequence contains the value, ignoring case considerations.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U containsIgnoringCase(CharSequence value);

  /**
   * Verifies that the CharSequence contains the value, only once.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U containsOnlyOnce(CharSequence value);

  /**
   * Verifies that the CharSequence contains the regular expression.
   *
   * @param regex the regex
   * @return the char sequence assert
   */
  U containsPattern(CharSequence regex);

  /**
   * Verifies that the CharSequence contains the values, in the given order without any other values
   * between them.
   *
   * @param values the values
   * @return the char sequence assert
   */
  U containsSequence(CharSequence... values);

  /**
   * Verifies that the CharSequence contains the values, in the given order, possibly with other
   * values between them.
   *
   * @param values the values
   * @return the char sequence assert
   */
  U containsSubsequence(CharSequence... values);

  /**
   * Verifies that the CharSequence does not contain the values.
   *
   * @param values the values
   * @return the char sequence assert
   */
  U doesNotContain(CharSequence... values);

  /**
   * Verifies that the CharSequence does not contain the regular expression.
   *
   * @param regex the regex
   * @return the char sequence assert
   */
  U doesNotContainPattern(CharSequence regex);

  /**
   * Verifies that the CharSequence does not end with the value.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U doesNotEndWith(CharSequence value);

  /**
   * Verifies that the CharSequence does not verify the regular expression.
   *
   * @param regex the regex
   * @return the char sequence assert
   */
  U doesNotMatch(CharSequence regex);

  /**
   * Verifies that the CharSequence does not start with the value.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U doesNotStartWith(CharSequence value);

  /**
   * Verifies that the CharSequence ends with the value.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U endsWith(CharSequence value);

  /**
   * Verifies that the CharSequence has the same size as the value.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U hasSameSizeAs(CharSequence value);

  /**
   * Verifies that the CharSequence is equal to the value, ignoring case.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isEqualToIgnoringCase(CharSequence value);

  /**
   * Verifies that the CharSequence is equal to the value, ignoring new lines.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isEqualToIgnoringNewLines(CharSequence value);

  /**
   * Verifies that the CharSequence is equal to the value, ignoring whitespace.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isEqualToIgnoringWhitespace(CharSequence value);

  /**
   * Verifies that the CharSequence is equal to the value, normalizing new lines.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isEqualToNormalizingNewlines(CharSequence value);

  /**
   * Verifies that the CharSequence is equal to the value, normalizing whitespace.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isEqualToNormalizingWhitespace(CharSequence value);

  /**
   * Verifies that the CharSequence is not equal to the value, ignoring case.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isNotEqualToIgnoringCase(CharSequence value);

  /**
   * Verifies that the CharSequence is not equal to the value, ignoring whitespace.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isNotEqualToIgnoringWhitespace(CharSequence value);

  /**
   * Verifies that the CharSequence is not equal to the value, normalizing whitespace.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isNotEqualToNormalizingWhitespace(CharSequence value);

  /**
   * Verifies that the CharSequence is a substring of the value.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U isSubstringOf(CharSequence value);

  /**
   * Verifies that the CharSequence is equal to the given XML after both have been formatted the
   * same way.
   *
   * @param xml the XML
   * @return the char sequence assert
   */
  U isXmlEqualTo(CharSequence xml);

  /**
   * Verifies that the CharSequence matches the regular expression.
   *
   * @param regex the regex
   * @return the char sequence assert
   */
  U matches(CharSequence regex);

  /**
   * Verifies that the CharSequence starts with the value.
   *
   * @param value the value
   * @return the char sequence assert
   */
  U startsWith(CharSequence value);
}
