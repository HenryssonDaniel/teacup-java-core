package org.teacup.core;

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
   * Returns the client.
   *
   * @param clientClass the class of the client
   * @param executor the executor
   * @param name the name of the client
   * @param <T> the client type
   * @return the client
   * @throws TeacupException if the client could not be retrieved
   */
  @SuppressWarnings("unchecked")
  public static <T> T getClient(Class<T> clientClass, Executor executor, String name)
      throws TeacupException {
    LOGGER.log(Level.FINE, "Getting the client: " + name + " with class: " + clientClass.getName());
    var setup = executor.getCurrentSetup();

    if (setup.isPresent()) {
      var wildcardClient = setup.get().getClients().get(name);

      if (wildcardClient != null) {
        if (clientClass.isAssignableFrom(wildcardClient.getClass())) return (T) wildcardClient;

        throw new TeacupException("The name exists, but is of a different instance");
      }

      throw new TeacupException("The client does not exist");
    }

    throw new TeacupException("No setup exists");
  }
}
