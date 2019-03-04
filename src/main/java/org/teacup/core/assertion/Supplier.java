package org.teacup.core.assertion;

@FunctionalInterface
interface Supplier<T> {
  void get(T value);
}
