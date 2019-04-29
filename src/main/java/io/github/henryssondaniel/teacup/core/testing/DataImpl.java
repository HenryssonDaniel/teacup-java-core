package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

class DataImpl implements Data {
  private final String name;
  private final Path path;
  private final Type type;

  private long timeFinished;
  private long timeStarted;

  DataImpl(String name, Path path, Type type) {
    this.name = name;
    this.path = path;
    this.type = type;
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
  public Type getType() {
    return type;
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
