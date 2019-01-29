package org.teacup.core;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Default implementation of {@link Setup}.
 *
 * @since 1.0
 */
public abstract class DefaultSetup implements Setup {
  private static final Logger LOGGER = Logger.getLogger(DefaultSetup.class.getName());
  private static final String LOG_GET = "Returning the %s";
  private static final String LOG_PUT = "Adding the %s: %s";

  private final Map<String, Client<?, ?, ?>> clients = new HashMap<>(0);
  private final Map<String, Server> servers = new HashMap<>(0);

  @Override
  public Map<String, Client<?, ?, ?>> getClients() {
    LOGGER.log(Level.FINE, String.format(LOG_GET, "clients"));
    return new HashMap<>(clients);
  }

  @Override
  public Map<String, Server> getServers() {
    LOGGER.log(Level.FINE, String.format(LOG_GET, "servers"));
    return new HashMap<>(servers);
  }

  @Override
  public Client<?, ?, ?> putClient(String name, Client<?, ?, ?> client) {
    LOGGER.log(Level.FINE, String.format(LOG_PUT, "client", name));
    return clients.put(name, client);
  }

  @Override
  public Server putServer(String name, Server server) {
    LOGGER.log(Level.FINE, String.format(LOG_PUT, "server", name));
    return servers.put(name, server);
  }
}
