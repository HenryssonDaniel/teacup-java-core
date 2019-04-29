package io.github.henryssondaniel.teacup.core.testing;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

class SuiteImpl extends DataImpl implements Suite {
  private static final Logger LOGGER = Factory.getLogger(SuiteImpl.class);

  private final Collection<Case> cases = new LinkedHashSet<>(0);
  private final Path path;
  private final Collection<Suite> suites = new LinkedHashSet<>(0);

  SuiteImpl(Collection<? extends Case> cases, Path path, Collection<? extends Suite> suites) {
    this.cases.addAll(cases);
    this.path = path;
    this.suites.addAll(suites);
  }

  @Override
  public Iterable<Case> getCases() {
    LOGGER.log(Level.FINE, "Get cases");
    return new LinkedHashSet<>(cases);
  }

  @Override
  public Path getPath() {
    return path;
  }

  @Override
  public Iterable<Suite> getSuites() {
    LOGGER.log(Level.FINE, "Get cases");
    return new LinkedHashSet<>(suites);
  }
}
