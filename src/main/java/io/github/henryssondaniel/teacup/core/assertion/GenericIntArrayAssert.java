package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic int array assertions.
 *
 * @param <T> the generic int array assert
 * @since 1.0
 */
public interface GenericIntArrayAssert<T extends GenericIntArrayAssert<T>>
    extends EnumerableAssert<int[], T> {}
