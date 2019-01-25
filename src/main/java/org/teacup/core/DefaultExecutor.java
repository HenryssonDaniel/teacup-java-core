package org.teacup.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

class DefaultExecutor implements Executor {
  private static final Logger LOGGER = Logger.getLogger(DefaultExecutor.class.getName());

  private Setup currentSetup;

  @Override
  public void executeFixture(Fixture fixture) {
    LOGGER.log(Level.FINE, "Executing fixture: " + fixture);

    if (fixture == null) tearDownFixture();
    else {
      var value = fixture.value();
      if (currentSetup == null || value != currentSetup.getClass())
        executeSetup(value.getConstructors());
    }
  }

  private void executeSetup(Constructor<?>... constructors) {
    tearDownFixture();

    if (constructors.length == 0)
      LOGGER.log(Level.SEVERE, "The setup class has no public constructor");
    else setUpFixture(constructors[0]);
  }

  private void setUpFixture(Constructor<?> constructor) {
    try {
      currentSetup = (Setup) constructor.newInstance();
      setUpTransport(currentSetup.getClients());
      setUpTransport(currentSetup.getServers());
    } catch (IllegalAccessException
        | IllegalArgumentException
        | InstantiationException
        | InvocationTargetException
        | SecurityException e) {
      LOGGER.log(Level.SEVERE, "Could not instantiate the setup class", e);
    }
  }

  private static void setUpTransport(Map<String, ? extends Transport> transports) {
    transports.forEach((name, transport) -> transport.setUp());
  }

  private void tearDownFixture() {
    if (currentSetup != null) {
      tearDownTransport(currentSetup.getClients());
      tearDownTransport(currentSetup.getServers());
      currentSetup = null;
    }
  }

  private static void tearDownTransport(Map<String, ? extends Transport> transports) {
    transports.forEach((name, transport) -> transport.tearDown());
  }
}
