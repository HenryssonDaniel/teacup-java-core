package io.github.henryssondaniel.teacup.core.assertion;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.assertj.core.data.Index;

/**
 * Abstract list assert.
 *
 * @param <T> the type
 * @param <U> the list type
 * @param <V> the generic list assert type
 * @since 1.0
 */
public abstract class AbstractListAssert<
        T, U extends List<? extends T>, V extends GenericListAssert<T, U, V>>
    extends AbstractIterableAssert<T, U, V> implements GenericListAssert<T, U, V> {
  private static final Logger LOGGER = Logger.getLogger(AbstractListAssert.class.getName());

  @Override
  public V contains(T value, int index) {
    LOGGER.log(Level.FINE, "Contains: {0} at index: {1}", new Object[] {value, index});
    addSupplier(() -> getAssert().contains(value, Index.atIndex(index)));
    return getAssertType();
  }

  @Override
  public V doesNotContain(T value, int index) {
    LOGGER.log(Level.FINE, "Does not contain: {0} at index: {1}", new Object[] {value, index});
    addSupplier(() -> getAssert().doesNotContain(value, Index.atIndex(index)));
    return getAssertType();
  }

  @Override
  abstract org.assertj.core.api.AbstractListAssert<?, U, T, ?> getAssert();
}
