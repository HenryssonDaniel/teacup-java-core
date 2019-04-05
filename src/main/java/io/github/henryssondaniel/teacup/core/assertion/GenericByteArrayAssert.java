package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic byte array assertions.
 *
 * @param <T> the generic byte array assert type
 * @since 1.0
 */
public interface GenericByteArrayAssert<T extends GenericByteArrayAssert<T>>
    extends EnumerableAssert<byte[], T> {}
