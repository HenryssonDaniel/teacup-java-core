package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic long assertions.
 *
 * @param <T> the generic long assert
 * @since 1.0
 */
public interface GenericLongAssert<T extends GenericLongAssert<T>>
    extends GenericComparableAssert<Long, T>, GenericNumberAssert<Long, T> {}
