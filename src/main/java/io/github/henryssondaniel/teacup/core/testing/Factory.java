package io.github.henryssondaniel.teacup.core.testing;

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
   * Creates a new test node.
   *
   * @param name the name
   * @param nodes the nodes
   * @return the test node
   * @since 1.1
   */
  public static Node createNode(String name, Collection<Node> nodes) {
    LOGGER.log(Level.FINE, NEW, "node");
    return new NodeImpl(name, nodes);
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
}
