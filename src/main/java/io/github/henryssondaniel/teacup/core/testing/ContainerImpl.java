package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;
import java.util.Collection;

class ContainerImpl extends RootImpl implements Container {
  private final Path path;

  ContainerImpl(
      Collection<? extends Container> containers,
      Collection<? extends Executable> executables,
      Path path) {
    super(containers, executables);
    this.path = path;
  }

  @Override
  public Path getPath() {
    return path;
  }
}
