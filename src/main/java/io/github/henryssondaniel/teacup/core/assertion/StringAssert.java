package io.github.henryssondaniel.teacup.core.assertion;

/**
 * String assertions.
 *
 * @param <T> the string assert
 * @since 1.0
 */
public interface StringAssert<T extends StringAssert<T>>
    extends CharSequenceAssert<String, T>, ComparableAssert<String, T> {}
