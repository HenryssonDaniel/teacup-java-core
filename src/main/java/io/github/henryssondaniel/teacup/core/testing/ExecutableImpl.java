package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;
import java.util.Collection;

class ExecutableImpl extends ContainerImpl implements Executable {
  private final String name;

  ExecutableImpl(
      Collection<? extends Container> containers,
      Collection<? extends Executable> executables,
      String name,
      Path path) {
    super(containers, executables, path);
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
