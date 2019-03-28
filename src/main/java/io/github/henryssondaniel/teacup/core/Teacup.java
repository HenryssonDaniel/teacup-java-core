package io.github.henryssondaniel.teacup.core;

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
   * @param clazz the class of the client
   * @param executor the executor
   * @param name the name of the client
   * @param <T> the client type
   * @return the client
   * @throws TeacupException if the client could not be retrieved
   */
  public static <T> T getClient(Class<T> clazz, Executor executor, String name)
      throws TeacupException {
    LOGGER.log(Level.FINE, "Getting the client: " + name + " with class: " + clazz.getName());

    var setup = executor.getCurrentSetup();
    if (setup.isPresent()) return get(clazz, setup.get().getClients().get(name), "client");

    throw new TeacupException("No setup exists");
  }

  /**
   * Returns the server.
   *
   * @param clazz the class of the server
   * @param executor the executor
   * @param name the name of the server
   * @param <T> the server type
   * @return the server
   * @throws TeacupException if the server could not be retrieved
   */
  public static <T extends Server> T getServer(Class<T> clazz, Executor executor, String name)
      throws TeacupException {
    LOGGER.log(Level.FINE, "Getting the server: " + name + " with class: " + clazz.getName());

    var setup = executor.getCurrentSetup();
    if (setup.isPresent()) return get(clazz, setup.get().getServers().get(name), "server");

    throw new TeacupException("No setup exists");
  }

  @SuppressWarnings("unchecked")
  private static <T> T get(Class<T> clazz, Object object, String type) throws TeacupException {
    if (object != null) {
      if (clazz.isAssignableFrom(object.getClass())) return (T) object;

      throw new TeacupException("The name exists, but is of a different instance");
    }

    throw new TeacupException("The " + type + " does not exist");
  }
}
