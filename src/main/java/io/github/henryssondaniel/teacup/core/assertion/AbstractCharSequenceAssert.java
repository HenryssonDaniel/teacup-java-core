package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract char sequence assert.
 *
 * @param <T> the char sequence type
 * @param <U> the generic char sequence assert type
 * @since 1.0
 */
public abstract class AbstractCharSequenceAssert<
        T extends CharSequence, U extends GenericCharSequenceAssert<T, U>>
    extends EnumerableAssertImpl<T, U> implements GenericCharSequenceAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(AbstractCharSequenceAssert.class.getName());

  @Override
  public U contains(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains: {0}", Arrays.toString(values));
    addSupplier(() -> getAssert().contains(values));
    return getAssertType();
  }

  @Override
  public U containsIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Contains ignoring case: {0}", value);
    addSupplier(() -> getAssert().containsIgnoringCase(value));
    return getAssertType();
  }

  @Override
  public U containsOnlyOnce(CharSequence value) {
    LOGGER.log(Level.FINE, "Contains only once: {0}", value);
    addSupplier(() -> getAssert().containsOnlyOnce(value));
    return getAssertType();
  }

  @Override
  public U containsPattern(CharSequence regex) {
    LOGGER.log(Level.FINE, "Contains pattern: {0}", regex);
    addSupplier(() -> getAssert().containsPattern(regex));
    return getAssertType();
  }

  @Override
  public U containsSequence(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains sequence: {0}", Arrays.toString(values));
    addSupplier(() -> getAssert().containsSequence(values));
    return getAssertType();
  }

  @Override
  public U containsSubsequence(CharSequence... values) {
    LOGGER.log(Level.FINE, "Contains sub sequence: {0}", Arrays.toString(values));
    addSupplier(() -> getAssert().containsSubsequence(values));
    return getAssertType();
  }

  @Override
  public U doesNotContain(CharSequence... values) {
    LOGGER.log(Level.FINE, "Does not contain: {0}", Arrays.toString(values));
    addSupplier(() -> getAssert().doesNotContain(values));
    return getAssertType();
  }

  @Override
  public U doesNotContainPattern(CharSequence regex) {
    LOGGER.log(Level.FINE, "Does not contain pattern: {0}", regex);
    addSupplier(() -> getAssert().doesNotContainPattern(regex));
    return getAssertType();
  }

  @Override
  public U doesNotEndWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Does not end with: {0}", value);
    addSupplier(() -> getAssert().doesNotEndWith(value));
    return getAssertType();
  }

  @Override
  public U doesNotMatch(CharSequence regex) {
    LOGGER.log(Level.FINE, "Does not match: {0}", regex);
    addSupplier(() -> getAssert().doesNotMatch(regex));
    return getAssertType();
  }

  @Override
  public U doesNotStartWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Does not start with: {0}", value);
    addSupplier(() -> getAssert().doesNotStartWith(value));
    return getAssertType();
  }

  @Override
  public U endsWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Ends with: {0}", value);
    addSupplier(() -> getAssert().endsWith(value));
    return getAssertType();
  }

  @Override
  public U hasSameSizeAs(CharSequence value) {
    LOGGER.log(Level.FINE, "Has same size as: {0}", value);
    addSupplier(() -> getAssert().hasSameSizeAs(value));
    return getAssertType();
  }

  @Override
  public U isEqualToIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring case: {0}", value);
    addSupplier(() -> getAssert().isEqualToIgnoringCase(value));
    return getAssertType();
  }

  @Override
  public U isEqualToIgnoringNewLines(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring new lines: {0}", value);
    addSupplier(() -> getAssert().isEqualToIgnoringNewLines(value));
    return getAssertType();
  }

  @Override
  public U isEqualToIgnoringWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to ignoring whitespace: {0}", value);
    addSupplier(() -> getAssert().isEqualToIgnoringWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isEqualToNormalizingNewlines(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to normalizing newlines: {0}", value);
    addSupplier(() -> getAssert().isEqualToNormalizingNewlines(value));
    return getAssertType();
  }

  @Override
  public U isEqualToNormalizingWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is equal to normalizing whitespace: {0}", value);
    addSupplier(() -> getAssert().isEqualToNormalizingWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualToIgnoringCase(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring case: {0}", value);
    addSupplier(() -> getAssert().isNotEqualToIgnoringCase(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualToIgnoringWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring whitespace: {0}", value);
    addSupplier(() -> getAssert().isNotEqualToIgnoringWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isNotEqualToNormalizingWhitespace(CharSequence value) {
    LOGGER.log(Level.FINE, "Is not equal to ignoring whitespace: {0}", value);
    addSupplier(() -> getAssert().isNotEqualToNormalizingWhitespace(value));
    return getAssertType();
  }

  @Override
  public U isSubstringOf(CharSequence value) {
    LOGGER.log(Level.FINE, "Is substring of: {0}", value);
    addSupplier(() -> getAssert().isSubstringOf(value));
    return getAssertType();
  }

  @Override
  public U isXmlEqualTo(CharSequence xml) {
    LOGGER.log(Level.FINE, "Is XML equal to: {0}", xml);
    addSupplier(() -> getAssert().isXmlEqualTo(xml));
    return getAssertType();
  }

  @Override
  public U matches(CharSequence regex) {
    LOGGER.log(Level.FINE, "Matches: {0}", regex);
    addSupplier(() -> getAssert().matches(regex));
    return getAssertType();
  }

  @Override
  public U startsWith(CharSequence value) {
    LOGGER.log(Level.FINE, "Starts with: {0}", value);
    addSupplier(() -> getAssert().startsWith(value));
    return getAssertType();
  }

  @Override
  @SuppressWarnings("unchecked")
  org.assertj.core.api.AbstractCharSequenceAssert<?, ? extends CharSequence> getAssert() {
    return assertThat(getActual());
  }
}
