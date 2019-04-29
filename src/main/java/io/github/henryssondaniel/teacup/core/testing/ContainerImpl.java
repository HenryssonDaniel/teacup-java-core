package io.github.henryssondaniel.teacup.core.testing;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

class ContainerImpl extends ExecutableImpl implements Container {
  private static final Logger LOGGER = Factory.getLogger(ContainerImpl.class);

  private final Collection<Case> cases = new LinkedHashSet<>(0);
  private final Collection<Suite> suites = new LinkedHashSet<>(0);

  ContainerImpl(Collection<? extends Case> cases, Collection<? extends Suite> suites) {
    this.cases.addAll(cases);
    this.suites.addAll(suites);
  }

  @Override
  public Iterable<Case> getCases() {
    LOGGER.log(Level.FINE, "Get cases");
    return new LinkedHashSet<>(cases);
  }

  @Override
  public Iterable<Suite> getSuites() {
    LOGGER.log(Level.FINE, "Get suites");
    return new LinkedHashSet<>(suites);
  }
}
