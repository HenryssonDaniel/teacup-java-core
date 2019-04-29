package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;
import java.util.Collection;
import java.util.LinkedHashSet;

class SuiteImpl implements Suite {
  private final Collection<Case> cases = new LinkedHashSet<>(0);
  private final Path path;
  private final Collection<Suite> suites = new LinkedHashSet<>(0);
  private long timeFinished;
  private long timeStarted;

  SuiteImpl(Collection<? extends Case> cases, Path path, Collection<? extends Suite> suites) {
    this.cases.addAll(cases);
    this.path = path;
    this.suites.addAll(suites);
  }

  @Override
  public Iterable<Case> getCases() {
    return new LinkedHashSet<>(cases);
  }

  @Override
  public Path getPath() {
    return path;
  }

  @Override
  public Iterable<Suite> getSuites() {
    return new LinkedHashSet<>(suites);
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
