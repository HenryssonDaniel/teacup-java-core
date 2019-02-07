package org.teacup.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
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
  void getClient() throws TeacupException {
    when(setup.getClients()).thenReturn(Collections.singletonMap(CLIENT, new TeacupTest()));
    assertThat(Teacup.getClient(Object.class, executor, CLIENT))
        .isExactlyInstanceOf(TeacupTest.class);
  }

  @Test
  void getClientWhenClientNotExists() {
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getClient(String.class, executor, CLIENT))
        .withMessage("The client does not exist");
  }

  @Test
  void getClientWhenNotCorrectInstance() {
    when(setup.getClients()).thenReturn(Collections.singletonMap(CLIENT, new Object()));
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getClient(TeacupTest.class, executor, CLIENT))
        .withMessage("The name exists, but is of a different instance");
  }

  @Test
  void getClientWhenNotPresent() {
    when(executor.getCurrentSetup()).thenReturn(Optional.empty());
    assertThatExceptionOfType(TeacupException.class)
        .isThrownBy(() -> Teacup.getClient(String.class, executor, CLIENT))
        .withMessage("No setup exists");
  }
}
