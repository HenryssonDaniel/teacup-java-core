package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class CharSequenceAssertImpl<T extends CharSequence, U extends CharSequenceAssert<T, U>>
    extends ObjectAssertImpl<T, U> implements CharSequenceAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(CharSequenceAssertImpl.class.getName());

  @Override
  public U contains(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).contains(values));
    return returnAssertType();
  }

  @Override
  public U containsIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Contains ignoring case: " + value);
    addSupplier(actual -> assertThat(actual).containsIgnoringCase(value));
    return returnAssertType();
  }

  @Override
  public U containsOnlyOnce(CharSequence value) {
    LOGGER.log(Level.FINE, "Contains only once: " + value);
    addSupplier(actual -> assertThat(actual).containsOnlyOnce(value));
    return returnAssertType();
  }

  @Override
  public U containsPattern(CharSequence regex) {
    LOGGER.log(Level.FINE, "Contains pattern: " + regex);
    addSupplier(actual -> assertThat(actual).containsPattern(regex));
    return returnAssertType();
  }

  @Override
  public U containsSequence(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains sequence: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsSequence(values));
    return returnAssertType();
  }

  @Override
  public U containsSubsequence(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains sub sequence: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).containsSubsequence(values));
    return returnAssertType();
  }

  @Override
  public U doesNotContain(CharSequence... values) {
    LOGGER.log(Level.FINE, "Does not contain: " + Arrays.toString(values));
    addSupplier(actual -> assertThat(actual).doesNotContain(values));
    return returnAssertType();
  }

  @Override
  public U doesNotContainPattern(CharSequence regex) {
    LOGGER.log(Level.FINE, "Does not contain pattern: " + regex);
    addSupplier(actual -> assertThat(actual).doesNotContainPattern(regex));
    return returnAssertType();
  }

  @Override
  public U doesNotEndWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Does not end with: " + value);
    addSupplier(actual -> assertThat(actual).doesNotEndWith(value));
    return returnAssertType();
  }

  @Override
  public U doesNotMatch(CharSequence regex) {
    LOGGER.log(Level.FINE, "Does not match: " + regex);
    addSupplier(actual -> assertThat(actual).doesNotMatch(regex));
    return returnAssertType();
  }

  @Override
  public U doesNotStartWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Does not start with: " + value);
    addSupplier(actual -> assertThat(actual).doesNotStartWith(value));
    return returnAssertType();
  }

  @Override
  public U endsWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Ends with: " + value);
    addSupplier(actual -> assertThat(actual).endsWith(value));
    return returnAssertType();
  }

  @Override
  public U hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same siz as: " + array);
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(array));
    return returnAssertType();
  }

  @Override
  public U hasSameSizeAs(Iterable<?> other) {
    List<String> otherAsString = new LinkedList<>();
    other.forEach(value -> otherAsString.add(value.toString()));

    LOGGER.log(Level.FINE, "Has same size as: " + Arrays.toString(otherAsString.toArray()));
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(other));

    return returnAssertType();
  }

  @Override
  public U hasSameSizeAs(CharSequence value) {
    LOGGER.log(Level.FINE, "Has same size as: " + value);
    addSupplier(actual -> assertThat(actual).hasSameSizeAs(value));
    return returnAssertType();
  }

  @Override
  public U hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: " + expected);
    addSupplier(actual -> assertThat(actual).hasSize(expected));
    return returnAssertType();
  }

  @Override
  public U isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(actual -> assertThat(actual).isEmpty());
    return returnAssertType();
  }

  @Override
  public U isEqualToIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring case: " + value);
    addSupplier(actual -> assertThat(actual).isEqualToIgnoringCase(value));
    return returnAssertType();
  }

  @Override
  public U isEqualToIgnoringNewLines(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring new lines: " + value);
    addSupplier(actual -> assertThat(actual).isEqualToIgnoringNewLines(value));
    return returnAssertType();
  }

  @Override
  public U isEqualToIgnoringWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring whitespace: " + value);
    addSupplier(actual -> assertThat(actual).isEqualToIgnoringWhitespace(value));
    return returnAssertType();
  }

  @Override
  public U isEqualToNormalizingNewlines(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to normalizing newlines: " + value);
    addSupplier(actual -> assertThat(actual).isEqualToNormalizingNewlines(value));
    return returnAssertType();
  }

  @Override
  public U isEqualToNormalizingWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to normalizing whitespace: " + value);
    addSupplier(actual -> assertThat(actual).isEqualToNormalizingWhitespace(value));
    return returnAssertType();
  }

  @Override
  public U isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(actual -> assertThat(actual).isNotEmpty());
    return returnAssertType();
  }

  @Override
  public U isNotEqualToIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring case: " + value);
    addSupplier(actual -> assertThat(actual).isNotEqualToIgnoringCase(value));
    return returnAssertType();
  }

  @Override
  public U isNotEqualToIgnoringWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring whitespace: " + value);
    addSupplier(actual -> assertThat(actual).isNotEqualToIgnoringWhitespace(value));
    return returnAssertType();
  }

  @Override
  public U isNotEqualToNormalizingWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring whitespace: " + value);
    addSupplier(actual -> assertThat(actual).isNotEqualToNormalizingWhitespace(value));
    return returnAssertType();
  }

  @Override
  public U isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(actual -> assertThat(actual).isNullOrEmpty());
    return returnAssertType();
  }

  @Override
  public U isSubstringOf(CharSequence value) {
    LOGGER.log(Level.FINE, "Is substring of: " + value);
    addSupplier(actual -> assertThat(actual).isSubstringOf(value));
    return returnAssertType();
  }

  @Override
  public U isXmlEqualTo(CharSequence xml) {
    LOGGER.log(Level.FINE, "Is XML equal to: " + xml);
    addSupplier(actual -> assertThat(actual).isXmlEqualTo(xml));
    return returnAssertType();
  }

  @Override
  public U matches(CharSequence regex) {
    LOGGER.log(Level.FINE, "Matches: " + regex);
    addSupplier(actual -> assertThat(actual).matches(regex));
    return returnAssertType();
  }

  @Override
  public U startsWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Starts with: " + value);
    addSupplier(actual -> assertThat(actual).startsWith(value));
    return returnAssertType();
  }
}
