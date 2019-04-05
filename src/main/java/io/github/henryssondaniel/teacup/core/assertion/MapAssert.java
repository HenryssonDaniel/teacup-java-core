package io.github.henryssondaniel.teacup.core.assertion;

import java.util.Map;

/**
 * Map assertions.
 *
 * @param <T> the key type
 * @param <U> the value type
 * @since 1.0
 */
public interface MapAssert<T, U> extends GenericMapAssert<T, U, Map<T, U>, MapAssert<T, U>> {}
