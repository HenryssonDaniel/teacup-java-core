package org.teacup.core;

import java.util.Map;

/**
 * Interface to describe the setup phase of a fixture.
 *
 * @since 1.0
 */
public interface Setup {
  /**
   * Returns the clients.
   *
   * @return the clients
   */
  Map<String, Object> getClients();

  /**
   * Returns the servers.
   *
   * @return the servers
   */
  Map<String, Server> getServers();

  /**
   * The initializer for the setup class. This method should prepare the setup class so that it can
   * be used from the executor.
   */
  void initialize();

  /**
   * Adds a client.
   *
   * @param name the name
   * @param client the client
   * @return the previous client associated with {@code name}, or {@code null} if there was no
   *     mapping for {@code name}.
   */
  Object putClient(String name, Object client);

  /**
   * Adds a server.
   *
   * @param name the name
   * @param server the server
   * @return the previous server associated with {@code name}, or {@code null} if there was no
   *     mapping for {@code name}.
   */
  Server putServer(String name, Server server);
}
