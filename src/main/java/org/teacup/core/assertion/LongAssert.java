package org.teacup.core.assertion;

/**
 * Long assertions.
 *
 * @param <T> the long assert
 * @since 1.0
 */
public interface LongAssert<T extends LongAssert<T>>
    extends ComparableAssert<Long, T>, NumberAssert<Long, T> {}
