package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Byte array assertions.
 *
 * @param <T> the byte array assert type
 * @since 1.0
 */
public interface ByteArrayAssert<T extends ByteArrayAssert<T>>
    extends EnumerableAssert<byte[], T> {}
