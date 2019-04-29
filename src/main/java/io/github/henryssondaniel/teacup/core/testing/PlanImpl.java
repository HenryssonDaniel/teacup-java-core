package io.github.henryssondaniel.teacup.core.testing;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class PlanImpl implements Plan {
  private static final Logger LOGGER = Factory.getLogger(PlanImpl.class);

  private final Set<Data> data = new LinkedHashSet<>(0);
  private long timeFinished;
  private long timeStarted;

  PlanImpl(Collection<? extends Data> data) {
    this.data.addAll(data);
  }

  @Override
  public Iterable<Data> getData() {
    LOGGER.log(Level.FINE, "Get data");
    return new LinkedHashSet<>(data);
  }

  @Override
  public long getTimeFinished() {
    return timeFinished;
  }

  @Override
  public long getTimeStarted() {
    return timeStarted;
  }

  @Override
  public void setTimeFinished(long timeFinished) {
    this.timeFinished = timeFinished;
  }

  @Override
  public void setTimeStarted(long timeStarted) {
    this.timeStarted = timeStarted;
  }
}
