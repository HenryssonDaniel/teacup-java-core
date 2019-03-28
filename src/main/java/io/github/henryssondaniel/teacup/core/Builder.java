package io.github.henryssondaniel.teacup.core;

/**
 * Builder.
 *
 * @param <T> the type
 * @since 1.0
 */
@FunctionalInterface
public interface Builder<T> {
  /**
   * Build.
   *
   * @return thr type
   */
  T build();
}
