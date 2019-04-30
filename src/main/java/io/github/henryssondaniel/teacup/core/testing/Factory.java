package io.github.henryssondaniel.teacup.core.testing;

import java.nio.file.Path;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Factory.
 *
 * @since 1.1
 */
public enum Factory {
  ;

  private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());
  private static final String NEW = "Creating a new {0}.";

  /**
   * Creates a new container.
   *
   * @param containers the containers
   * @param executables the executables
   * @param path the path
   * @return the container
   * @since 1.1
   */
  public static Container createContainer(
      Collection<? extends Container> containers,
      Collection<? extends Executable> executables,
      Path path) {
    LOGGER.log(Level.FINE, NEW, "container");
    return new ContainerImpl(containers, executables, path);
  }

  /**
   * Creates a new executable.
   *
   * @param containers the containers
   * @param executables the executables
   * @param name the name
   * @param path the path
   * @return the executable
   * @since 1.1
   */
  public static Executable createExecutable(
      Collection<? extends Container> containers,
      Collection<? extends Executable> executables,
      String name,
      Path path) {
    LOGGER.log(Level.FINE, NEW, "executable");
    return new ExecutableImpl(containers, executables, name, path);
  }

  /**
   * Creates a new result.
   *
   * @param status the status
   * @param throwable the throwable
   * @return the result
   * @since 1.1
   */
  public static Result createResult(Status status, Throwable throwable) {
    LOGGER.log(Level.FINE, NEW, "result");
    return new ResultImpl(status, throwable);
  }

  /**
   * Creates a new root.
   *
   * @param executables the containers
   * @param containers the executables
   * @return the root
   * @since 1.1
   */
  public static Root createRoot(
      Collection<? extends Container> containers, Collection<? extends Executable> executables) {
    LOGGER.log(Level.FINE, NEW, "container");
    return new RootImpl(containers, executables);
  }
}
