package org.teacup.core;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class containing useful methods.
 *
 * @since 1.0
 */
public enum Teacup {
  ;

  private static final Logger LOGGER = Logger.getLogger(Teacup.class.getName());

  /**
   * Returns the client. If the client is not found, an empty Optional is returned.
   *
   * @param clientClass the class of the client
   * @param executor the executor
   * @param name the name of the client
   * @param <T> the client type
   * @return the client
   */
  @SuppressWarnings("unchecked")
  public static <T> Optional<T> getClient(Class<T> clientClass, Executor executor, String name) {
    T client = null;

    var setup = executor.getCurrentSetup();
    if (setup.isPresent()) {
      var wildcardClient = setup.get().getClients().get(name);

      if (wildcardClient == null) LOGGER.log(Level.SEVERE, "The client does not exist");
      else if (clientClass.isAssignableFrom(wildcardClient.getClass())) client = (T) wildcardClient;
      else LOGGER.log(Level.SEVERE, "The name exists, but is of a different instance");
    } else LOGGER.log(Level.SEVERE, "No setup exists.");

    return Optional.ofNullable(client);
  }
}
