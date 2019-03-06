package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.api.AbstractCharSequenceAssert;

class CharSequenceAssertImpl<T extends CharSequence, U extends CharSequenceAssert<T, U>>
    extends ObjectAssertImpl<T, U> implements CharSequenceAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(CharSequenceAssertImpl.class.getName());

  @Override
  public U contains(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains: " + Arrays.toString(values));
    addSupplier(() -> getAssert().contains(values));
    return getAssertType();
  }

  @Override
  public U containsIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Contains ignoring case: " + value);
    addSupplier(() -> getAssert().containsIgnoringCase(value));
    return getAssertType();
  }

  @Override
  public U containsOnlyOnce(CharSequence value) {
    LOGGER.log(Level.FINE, "Contains only once: " + value);
    addSupplier(() -> getAssert().containsOnlyOnce(value));
    return getAssertType();
  }

  @Override
  public U containsPattern(CharSequence regex) {
    LOGGER.log(Level.FINE, "Contains pattern: " + regex);
    addSupplier(() -> getAssert().containsPattern(regex));
    return getAssertType();
  }

  @Override
  public U containsSequence(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains sequence: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsSequence(values));
    return getAssertType();
  }

  @Override
  public U containsSubsequence(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains sub sequence: " + Arrays.toString(values));
    addSupplier(() -> getAssert().containsSubsequence(values));
    return getAssertType();
  }

  @Override
  public U doesNotContain(CharSequence... values) {
    LOGGER.log(Level.FINE, "Does not contain: " + Arrays.toString(values));
    addSupplier(() -> getAssert().doesNotContain(values));
    return getAssertType();
  }

  @Override
  public U doesNotContainPattern(CharSequence regex) {
    LOGGER.log(Level.FINE, "Does not contain pattern: " + regex);
    addSupplier(() -> getAssert().doesNotContainPattern(regex));
    return getAssertType();
  }

  @Override
  public U doesNotEndWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Does not end with: " + value);
    addSupplier(() -> getAssert().doesNotEndWith(value));
    return getAssertType();
  }

  @Override
  public U doesNotMatch(CharSequence regex) {
    LOGGER.log(Level.FINE, "Does not match: " + regex);
    addSupplier(() -> getAssert().doesNotMatch(regex));
    return getAssertType();
  }

  @Override
  public U doesNotStartWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Does not start with: " + value);
    addSupplier(() -> getAssert().doesNotStartWith(value));
    return getAssertType();
  }

  @Override
  public U endsWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Ends with: " + value);
    addSupplier(() -> getAssert().endsWith(value));
    return getAssertType();
  }

  @Override
  public U hasSameSizeAs(Iterable<?> other) {
    List<String> otherAsString = new LinkedList<>();
    other.forEach(value -> otherAsString.add(value.toString()));

    LOGGER.log(Level.FINE, "Has same size as: " + Arrays.toString(otherAsString.toArray()));
    addSupplier(() -> getAssert().hasSameSizeAs(other));

    return getAssertType();
  }

  @Override
  public U hasSameSizeAs(Object array) {
    LOGGER.log(Level.FINE, "Has same siz as: " + array);
    addSupplier(() -> getAssert().hasSameSizeAs(array));
    return getAssertType();
  }

  @Override
  public U hasSameSizeAs(CharSequence value) {
    LOGGER.log(Level.FINE, "Has same size as: " + value);
    addSupplier(() -> getAssert().hasSameSizeAs(value));
    return getAssertType();
  }

  @Override
  public U hasSize(int expected) {
    LOGGER.log(Level.FINE, "Has size: " + expected);
    addSupplier(() -> getAssert().hasSize(expected));
    return getAssertType();
  }

  @Override
  public U isEmpty() {
    LOGGER.log(Level.FINE, "Is empty");
    addSupplier(() -> getAssert().isEmpty());
    return getAssertType();
  }

  @Override
  public U isEqualToIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring case: " + value);
    addSupplier(() -> getAssert().isEqualToIgnoringCase(value));
    return getAssertType();
  }

  @Override
  public U isEqualToIgnoringNewLines(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring new lines: " + value);
    addSupplier(() -> getAssert().isEqualToIgnoringNewLines(value));
    return getAssertType();
  }

  @Override
  public U isEqualToIgnoringWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring whitespace: " + value);
    addSupplier(() -> getAssert().isEqualToIgnoringWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isEqualToNormalizingNewlines(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to normalizing newlines: " + value);
    addSupplier(() -> getAssert().isEqualToNormalizingNewlines(value));
    return getAssertType();
  }

  @Override
  public U isEqualToNormalizingWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to normalizing whitespace: " + value);
    addSupplier(() -> getAssert().isEqualToNormalizingWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isNotEmpty() {
    LOGGER.log(Level.FINE, "Is not empty");
    addSupplier(() -> getAssert().isNotEmpty());
    return getAssertType();
  }

  @Override
  public U isNotEqualToIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring case: " + value);
    addSupplier(() -> getAssert().isNotEqualToIgnoringCase(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualToIgnoringWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring whitespace: " + value);
    addSupplier(() -> getAssert().isNotEqualToIgnoringWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualToNormalizingWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring whitespace: " + value);
    addSupplier(() -> getAssert().isNotEqualToNormalizingWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isNullOrEmpty() {
    LOGGER.log(Level.FINE, "Is null or empty");
    addSupplier(() -> getAssert().isNullOrEmpty());
    return getAssertType();
  }

  @Override
  public U isSubstringOf(CharSequence value) {
    LOGGER.log(Level.FINE, "Is substring of: " + value);
    addSupplier(() -> getAssert().isSubstringOf(value));
    return getAssertType();
  }

  @Override
  public U isXmlEqualTo(CharSequence xml) {
    LOGGER.log(Level.FINE, "Is XML equal to: " + xml);
    addSupplier(() -> getAssert().isXmlEqualTo(xml));
    return getAssertType();
  }

  @Override
  public U matches(CharSequence regex) {
    LOGGER.log(Level.FINE, "Matches: " + regex);
    addSupplier(() -> getAssert().matches(regex));
    return getAssertType();
  }

  @Override
  public U startsWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Starts with: " + value);
    addSupplier(() -> getAssert().startsWith(value));
    return getAssertType();
  }

  @Override
  AbstractCharSequenceAssert<?, T> getAssert() {
    return (AbstractCharSequenceAssert<?, T>) assertThat(getActual());
  }
}
