package io.github.henryssondaniel.teacup.core.reporting;

import java.nio.file.Path;

class TestCaseImpl implements TestCase {
  private final String name;
  private final Path path;

  private TestStatus testStatus = TestStatus.INITIALIZED;
  private long timeFinished;
  private long timeStarted;

  TestCaseImpl(String name, Path path) {
    this.name = name;
    this.path = path;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Path getPath() {
    return path;
  }

  @Override
  public TestStatus getTestStatus() {
    return testStatus;
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
  public void setTestStatus(TestStatus testStatus) {
    this.testStatus = testStatus;
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
