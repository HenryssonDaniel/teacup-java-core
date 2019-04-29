package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;
import java.util.Collection;

class SuiteImpl extends ContainerImpl implements Suite {
  private final Path path;

  SuiteImpl(Collection<? extends Case> cases, Path path, Collection<? extends Suite> suites) {
    super(cases, suites);
    this.path = path;
  }

  @Override
  public Path getPath() {
    return path;
  }
}
