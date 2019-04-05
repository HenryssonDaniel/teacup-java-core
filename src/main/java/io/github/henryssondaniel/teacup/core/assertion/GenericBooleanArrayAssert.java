package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic boolean array assertions.
 *
 * @param <T> the generic boolean array assert type
 * @since 1.0
 */
public interface GenericBooleanArrayAssert<T extends GenericBooleanArrayAssert<T>>
    extends EnumerableAssert<boolean[], T> {}
