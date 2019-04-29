package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;

class CaseImpl extends DataImpl implements Case {
  private final String name;
  private final Path path;

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
}
