package org.teacup.core.assertion;

class LongAssertImpl<T extends LongAssert<T>> extends ComparableAssertImpl<Long, T>
    implements LongAssert<T> {}
