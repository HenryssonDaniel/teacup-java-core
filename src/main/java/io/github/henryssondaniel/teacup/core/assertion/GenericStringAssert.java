package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic string assertions.
 *
 * @param <T> the generic string assert
 * @since 1.0
 */
public interface GenericStringAssert<T extends GenericStringAssert<T>>
    extends GenericCharSequenceAssert<String, T>, GenericComparableAssert<String, T> {}
