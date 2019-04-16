package io.github.henryssondaniel.teacup.core;

import static io.github.henryssondaniel.teacup.core.Constants.CLIENT;
import static io.github.henryssondaniel.teacup.core.Constants.CLIENT_NAME;
import static io.github.henryssondaniel.teacup.core.Constants.SERVER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

class ExecutorTest {
  @Test
  void executeFixture() {
    var executor = ExecutorFactory.create();
    executor.executeFixture(TestSetup.class.getAnnotation(Fixture.class));

    var setup = executor.getCurrentSetup().orElseThrow();

    var clients = setup.getClients();
    assertThat(clients).containsKey(CLIENT_NAME);
    assertThat(clients).containsValues(CLIENT);
    assertThat(clients).hasSize(1);

    var servers = setup.getServers();
    var testServer = (TestServer) servers.get(SERVER_NAME);

    assertThat(servers).containsKey(SERVER_NAME);
    assertThat(servers).containsValue(testServer);
    assertThat(servers).hasSize(1);

    assertThat(testServer.isSetUp()).isTrue();
    assertThat(testServer.isTearDown()).isFalse();

    executor.executeFixture(null);
    assertThat(executor.getCurrentSetup()).isEmpty();
    assertThat(testServer.isTearDown()).isTrue();

    executor.executeFixture(PrivateSetup.class.getAnnotation(Fixture.class));
    assertThat(executor.getCurrentSetup()).isEmpty();

    executor.executeFixture(ConstructorSetup.class.getAnnotation(Fixture.class));
    assertThat(executor.getCurrentSetup()).isEmpty();
  }

  @Fixture(PrivateSetup.class)
  private static final class PrivateSetup extends DefaultSetup {
    private static final Logger LOGGER = Logger.getLogger(PrivateSetup.class.getName());

    @Override
    public void initialize() {
      LOGGER.log(Level.FINE, "Initialize");
    }
  }
}
