package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Comparable assertions.
 *
 * @param <T>the comparable type
 * @since 1.0
 */
public interface ComparableAssert<T extends Comparable<? super T>>
    extends GenericComparableAssert<T, ComparableAssert<T>> {}
