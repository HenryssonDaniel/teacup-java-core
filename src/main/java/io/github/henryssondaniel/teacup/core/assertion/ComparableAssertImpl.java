package io.github.henryssondaniel.teacup.core.assertion;

class ComparableAssertImpl<T extends Comparable<? super T>>
    extends AbstractComparableAssert<T, ComparableAssert<T>> implements ComparableAssert<T> {}
