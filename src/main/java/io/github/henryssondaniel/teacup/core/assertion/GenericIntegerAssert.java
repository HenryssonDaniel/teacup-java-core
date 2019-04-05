package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic integer assertions.
 *
 * @param <T> the generic integer assert
 * @since 1.0
 */
public interface GenericIntegerAssert<T extends GenericIntegerAssert<T>>
    extends GenericComparableAssert<Integer, T>, GenericNumberAssert<Integer, T> {}
