package org.teacup.core.assertion;

class IntegerAssertImpl<T extends IntegerAssert<T>> extends ComparableAssertImpl<Integer, T>
    implements IntegerAssert<T> {}
