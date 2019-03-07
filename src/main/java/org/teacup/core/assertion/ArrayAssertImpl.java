package org.teacup.core.assertion;

import org.assertj.core.api.AbstractArrayAssert;

abstract class ArrayAssertImpl<T, U extends ArrayAssert<T, U>> extends EnumerableAssertImpl<T, U>
    implements ArrayAssert<T, U> {
  @Override
  abstract AbstractArrayAssert<?, T, ?> getAssert();
}
