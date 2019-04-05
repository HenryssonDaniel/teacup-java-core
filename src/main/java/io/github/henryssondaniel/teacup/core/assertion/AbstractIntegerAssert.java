package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Abstract integer assert.
 *
 * @param <T> the generic integer assert type
 * @since 1.0
 */
public abstract class AbstractIntegerAssert<T extends GenericIntegerAssert<T>>
    extends AbstractComparableAssert<Integer, T> implements GenericIntegerAssert<T> {}
