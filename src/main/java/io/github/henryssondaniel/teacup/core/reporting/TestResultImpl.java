package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestResultImpl implements TestResult {
  private static final Logger LOGGER = Factory.getLogger(TestResultImpl.class);

  private final TestStatus testStatus;
  private final Throwable throwable;

  TestResultImpl(TestStatus testStatus, Throwable throwable) {
    this.testStatus = testStatus;
    this.throwable = throwable;
  }

  @Override
  public TestStatus getTestStatus() {
    return testStatus;
  }

  @Override
  public Optional<Throwable> getThrowable() {
    LOGGER.log(Level.FINE, "Get throwable");
    return Optional.ofNullable(throwable);
  }
}
