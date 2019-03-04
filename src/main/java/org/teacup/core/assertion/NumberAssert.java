package org.teacup.core.assertion;

/**
 * Number assertions.
 *
 * @param <T> the number type
 * @param <U> the number assert type
 * @since 1.0
 */
public interface NumberAssert<T extends Number, U extends NumberAssert<T, U>>
    extends ObjectAssert<T, U> {}
