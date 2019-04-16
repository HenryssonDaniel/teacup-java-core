package io.github.henryssondaniel.teacup.core;

import static io.github.henryssondaniel.teacup.core.Constants.CLIENT;
import static io.github.henryssondaniel.teacup.core.Constants.CLIENT_NAME;
import static io.github.henryssondaniel.teacup.core.Constants.SERVER_NAME;

import java.util.logging.Level;
import java.util.logging.Logger;

@Fixture(TestSetup.class)
public class TestSetup extends DefaultSetup {
  private static final Logger LOGGER = Logger.getLogger(TestSetup.class.getName());

  private final Server server = new TestServerImpl();

  @Override
  public void initialize() {
    LOGGER.log(Level.FINE, "Initialize");
    putClient(CLIENT_NAME, CLIENT);
    putServer(SERVER_NAME, server);
  }
}
