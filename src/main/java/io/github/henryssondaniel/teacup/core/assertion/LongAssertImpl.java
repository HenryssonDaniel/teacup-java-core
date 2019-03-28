package io.github.henryssondaniel.teacup.core.assertion;

class LongAssertImpl<T extends LongAssert<T>> extends ComparableAssertImpl<Long, T>
    implements LongAssert<T> {}
