package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

class CaseImpl implements Case {
  private final String name;
  private final Path path;

  private long timeFinished;
  private long timeStarted;

  CaseImpl(String name, Path path) {
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
