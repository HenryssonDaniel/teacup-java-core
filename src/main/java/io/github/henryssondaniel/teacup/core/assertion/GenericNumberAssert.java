package io.github.henryssondaniel.teacup.core.assertion;

/**
 * Generic number assertions.
 *
 * @param <T> the number type
 * @param <U> the generic number assert type
 * @since 1.0
 */
public interface GenericNumberAssert<T extends Number, U extends GenericNumberAssert<T, U>>
    extends GenericObjectAssert<T, U> {}
