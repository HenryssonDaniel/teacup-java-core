package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Abstract long assert.
 *
 * @param <T> the generic long assert type
 * @since 1.0
 */
public abstract class AbstractLongAssert<T extends GenericLongAssert<T>>
    extends AbstractComparableAssert<Long, T> implements GenericLongAssert<T> {}
