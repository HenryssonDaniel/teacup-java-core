package io.github.henryssondaniel.teacup.core.testing;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResultImpl implements Result {
  private static final Logger LOGGER = Factory.getLogger(ResultImpl.class);

  private final Status status;
  private final Throwable throwable;

  ResultImpl(Status status, Throwable throwable) {
    this.status = status;
    this.throwable = throwable;
  }

  @Override
  public Status getStatus() {
    return status;
  }

  @Override
  public Optional<Throwable> getThrowable() {
    LOGGER.log(Level.FINE, "Get throwable");
    return Optional.ofNullable(throwable);
  }
}
