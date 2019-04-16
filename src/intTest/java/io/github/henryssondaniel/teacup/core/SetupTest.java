package io.github.henryssondaniel.teacup.core;

import static io.github.henryssondaniel.teacup.core.Constants.CLIENT;
import static io.github.henryssondaniel.teacup.core.Constants.CLIENT_NAME;
import static io.github.henryssondaniel.teacup.core.Constants.SERVER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SetupTest {
  @Test
  void initialize() {
    Setup setup = new TestSetup();

    assertThat(setup.getClients()).isEmpty();
    assertThat(setup.getServers()).isEmpty();

    setup.initialize();

    var clients = setup.getClients();
    assertThat(clients).containsKey(CLIENT_NAME);
    assertThat(clients).containsValues(CLIENT);
    assertThat(clients).hasSize(1);

    var servers = setup.getServers();
    var testServer = (TestServer) servers.get(SERVER_NAME);

    assertThat(servers).containsKey(SERVER_NAME);
    assertThat(servers).containsValue(testServer);
    assertThat(servers).hasSize(1);

    assertThat(testServer.isSetUp()).isFalse();
    assertThat(testServer.isTearDown()).isFalse();
  }
}
