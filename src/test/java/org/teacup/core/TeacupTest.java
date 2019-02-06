package org.teacup.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TeacupTest {
  private static final String CLIENT = "client";

  private final Executor executor = mock(Executor.class);
  private final Setup setup = mock(Setup.class);

  @BeforeEach
  void beforeEach() {
    when(executor.getCurrentSetup()).thenReturn(Optional.of(setup));
  }

  @Test
  void getClient() {
    when(setup.getClients()).thenReturn(Collections.singletonMap(CLIENT, new TeacupTest()));
    assertThat(Teacup.getClient(Object.class, executor, CLIENT))
        .containsInstanceOf(TeacupTest.class);
  }

  @Test
  void getClientWhenClientNotExists() {
    assertThat(Teacup.getClient(String.class, executor, CLIENT)).isEmpty();
  }

  @Test
  void getClientWhenNotCorrectInstance() {
    when(setup.getClients()).thenReturn(Collections.singletonMap(CLIENT, new Object()));
    assertThat(Teacup.getClient(TeacupTest.class, executor, CLIENT)).isEmpty();
  }

  @Test
  void getClientWhenNotPresent() {
    when(executor.getCurrentSetup()).thenReturn(Optional.empty());
    assertThat(Teacup.getClient(String.class, executor, CLIENT)).isEmpty();
  }
}
