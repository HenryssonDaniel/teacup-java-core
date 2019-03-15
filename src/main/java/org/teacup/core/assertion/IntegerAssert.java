package org.teacup.core.assertion;

/**
 * Integer assertions.
 *
 * @param <T> the integer assert
 * @since 1.0
 */
public interface IntegerAssert<T extends IntegerAssert<T>>
    extends ComparableAssert<Integer, T>, NumberAssert<Integer, T> {}
