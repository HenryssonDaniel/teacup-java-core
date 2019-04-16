package io.github.henryssondaniel.teacup.core;

import static io.github.henryssondaniel.teacup.core.Constants.CLIENT;
import static io.github.henryssondaniel.teacup.core.Constants.CLIENT_NAME;
import static io.github.henryssondaniel.teacup.core.Constants.SERVER_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacupTest {
  private final Executor executor = ExecutorFactory.create();

  @BeforeEach
  void beforeEach() {
    executor.executeFixture(TestSetup.class.getAnnotation(Fixture.class));
  }

  @Test
  void getClient() throws TeacupException {
    assertThat(Teacup.getClient(Object.class, executor, CLIENT_NAME)).isSameAs(CLIENT);
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getClient(Object.class, executor, SERVER_NAME));
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getClient(Integer.class, executor, CLIENT_NAME));
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getClient(Object.class, ExecutorFactory.create(), CLIENT_NAME));
  }

  @Test
  void getServer() throws TeacupException {
    assertThat(Teacup.getServer(TestServer.class, executor, SERVER_NAME))
        .isSameAs(executor.getCurrentSetup().orElseThrow().getServers().get(SERVER_NAME));
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getServer(TestServer.class, executor, CLIENT_NAME));
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getServer(ExtendedServer.class, executor, SERVER_NAME));
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(
            () -> Teacup.getServer(TestServer.class, ExecutorFactory.create(), SERVER_NAME));
  }

  private static final class ExtendedServer implements Server {
    private static final Logger LOGGER = Logger.getLogger(ExtendedServer.class.getName());

    @Override
    public void setUp() {
      LOGGER.log(Level.FINE, "Set up");
    }

    @Override
    public void tearDown() {
      LOGGER.log(Level.FINE, "Tear down");
    }
  }
}
