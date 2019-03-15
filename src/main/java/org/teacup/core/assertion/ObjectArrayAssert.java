package org.teacup.core.assertion;

/**
 * Object array assertions.
 *
 * @param <T> the array type
 * @param <U> the object array type
 * @since 1.0
 */
public interface ObjectArrayAssert<T, U extends ObjectArrayAssert<T, U>>
    extends EnumerableAssert<T[], U> {}
