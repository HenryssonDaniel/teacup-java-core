package io.github.henryssondaniel.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.data.Index;

class ListAssertImpl<T, U extends ListAssert<T, U>>
    extends IterableAssertImpl<T, List<? extends T>, U> implements ListAssert<T, U> {
  private static final Logger LOGGER = Logger.getLogger(ListAssertImpl.class.getName());

  @Override
  public U contains(T value, int index) {
    LOGGER.log(Level.FINE, "Contains: {0} at index: {1}", new Object[] {value, index});
    addSupplier(() -> getAssert().contains(value, Index.atIndex(index)));
    return getAssertType();
  }

  @Override
  public U doesNotContain(T value, int index) {
    LOGGER.log(Level.FINE, "Does not contain: {0} at index: {1}", new Object[] {value, index});
    addSupplier(() -> getAssert().doesNotContain(value, Index.atIndex(index)));
    return getAssertType();
  }

  @Override
  org.assertj.core.api.ListAssert<T> getAssert() {
    return assertThat(getActual());
  }
}
