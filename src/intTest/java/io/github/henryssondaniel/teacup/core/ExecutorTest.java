package io.github.henryssondaniel.teacup.core;

import static io.github.henryssondaniel.teacup.core.Constants.CLIENT;
import static io.github.henryssondaniel.teacup.core.Constants.CLIENT_NAME;
import static io.github.henryssondaniel.teacup.core.Constants.SERVER;
import static io.github.henryssondaniel.teacup.core.Constants.SERVER_NAME;
import static org.assertj.core.api.Assertions.assertThat;

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
    assertThat(servers).containsKey(SERVER_NAME);
    assertThat(servers).containsValue(SERVER);
    assertThat(servers).hasSize(1);

    assertThat(SERVER.isSetUp()).isTrue();
    assertThat(SERVER.isTearDown()).isFalse();
  }
}
