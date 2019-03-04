package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.data.Index;

class ListAssertImpl<T, U extends List<T>, V extends ListAssert<T, U, V>>
    extends IterableAssertImpl<T, U, V> implements ListAssert<T, U, V> {
  private static final Logger LOGGER = Logger.getLogger(ListAssertImpl.class.getName());

  @Override
  public V contains(T value, int index) {
    LOGGER.log(Level.FINE, "Contains: " + value + " at index: " + index);
    addSupplier(actual -> assertThat(actual).contains(value, Index.atIndex(index)));
    return returnAssertType();
  }

  @Override
  public V doesNotContain(T value, int index) {
    LOGGER.log(Level.FINE, "Does not contain: " + value + " at index: " + index);
    addSupplier(actual -> assertThat(actual).doesNotContain(value, Index.atIndex(index)));
    return returnAssertType();
  }
}
