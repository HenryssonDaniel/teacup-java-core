package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic object array assertions.
 *
 * @param <T> the array type
 * @param <U> the generic object array type
 * @since 1.0
 */
public interface GenericObjectArrayAssert<T, U extends GenericObjectArrayAssert<T, U>>
    extends EnumerableAssert<T[], U> {}
