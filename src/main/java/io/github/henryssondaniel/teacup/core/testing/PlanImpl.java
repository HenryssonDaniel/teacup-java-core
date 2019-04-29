package io.github.henryssondaniel.teacup.core.testing;

import java.util.Collection;
import java.util.LinkedHashSet;

class PlanImpl implements Plan {
  private final Collection<Case> cases = new LinkedHashSet<>(0);
  private final Collection<Suite> suites = new LinkedHashSet<>(0);

  private long timeFinished;
  private long timeStarted;

  PlanImpl(Collection<? extends Case> cases, Collection<? extends Suite> suites) {
    this.cases.addAll(cases);
    this.suites.addAll(suites);
  }

  @Override
  public Iterable<Case> getCases() {
    return new LinkedHashSet<>(cases);
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
