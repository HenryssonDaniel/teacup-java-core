package io.github.henryssondaniel.teacup.core.testing;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

class RootImpl implements Root {
  private static final Logger LOGGER = Factory.getLogger(RootImpl.class);

  private final Collection<Container> containers = new LinkedHashSet<>(0);
  private final Collection<Executable> executables = new LinkedHashSet<>(0);

  private long timeFinished;
  private long timeStarted;

  RootImpl(
      Collection<? extends Container> containers, Collection<? extends Executable> executables) {
    this.containers.addAll(containers);
    this.executables.addAll(executables);
  }

  @Override
  public Iterable<Container> getContainers() {
    LOGGER.log(Level.FINE, "Get containers");
    return new LinkedHashSet<>(containers);
  }

  @Override
  public Iterable<Executable> getExecutables() {
    LOGGER.log(Level.FINE, "Get executables");
    return new LinkedHashSet<>(executables);
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
