package org.teacup.core.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;

class BooleanAssertImpl extends ObjectAssertImpl<Boolean, BooleanAssert> implements BooleanAssert {
  private static final Logger LOGGER = Logger.getLogger(BooleanAssertImpl.class.getName());

  @Override
  public BooleanAssert isFalse() {
    LOGGER.log(Level.FINE, "Is false");
    addSupplier(actual -> assertThat(actual).isFalse());
    return returnAssertType();
  }

  @Override
  public BooleanAssert isTrue() {
    LOGGER.log(Level.FINE, "Is true");
    addSupplier(actual -> assertThat(actual).isTrue());
    return returnAssertType();
  }
}
