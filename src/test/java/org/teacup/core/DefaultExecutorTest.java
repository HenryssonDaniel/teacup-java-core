package org.teacup.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class DefaultExecutorTest {
  private static final String CURRENT_SETUP = "currentSetup";

  private final Executor executor = new DefaultExecutor();
  private final Fixture fixture = mock(Fixture.class);

  @Test
  void executeClassWithFixtureAndNoPublicClass()
      throws IllegalAccessException, NoSuchFieldException {
    doReturn(Setup.class).when(fixture).value();
    executor.executeFixture(fixture);
    assertThat(getCurrentSetup()).isNull();
  }

  @Test
  void executeClassWithFixtureAndNoPublicConstructor()
      throws IllegalAccessException, NoSuchFieldException {
    doReturn(DefaultSetup.class).when(fixture).value();
    executor.executeFixture(fixture);
    assertThat(getCurrentSetup()).isNull();
  }

  @Test
  void executeClassWithFixtureDifferentAsCurrent()
      throws IllegalAccessException, NoSuchFieldException {
    setCurrentSetup(new TestSubSetup());

    doReturn(TestSetup.class).when(fixture).value();
    executor.executeFixture(fixture);

    assertThat(getCurrentSetup()).isExactlyInstanceOf(TestSetup.class);
  }

  @Test
  void executeClassWithFixtureSameAsCurrent() throws IllegalAccessException, NoSuchFieldException {
    setCurrentSetup(new TestSetup());

    doReturn(TestSetup.class).when(fixture).value();
    executor.executeFixture(fixture);

    assertThat(getCurrentSetup()).isExactlyInstanceOf(TestSetup.class);
  }

  @Test
  void executeClassWithoutFixtureWhenCurrent() throws IllegalAccessException, NoSuchFieldException {
    var setup = mock(Setup.class);
    setCurrentSetup(setup);

    executor.executeFixture(null);

    verify(setup).getServers();
    assertThat(getCurrentSetup()).isNull();
  }

  @Test
  void executeFixtureWithoutFixture() throws IllegalAccessException, NoSuchFieldException {
    executor.executeFixture(null);
    assertThat(getCurrentSetup()).isNull();
  }

  private Object getCurrentSetup() throws IllegalAccessException, NoSuchFieldException {
    return Utils.getField(DefaultExecutor.class, executor, CURRENT_SETUP);
  }

  private void setCurrentSetup(Object value) throws IllegalAccessException, NoSuchFieldException {
    Utils.setField(DefaultExecutor.class, executor, CURRENT_SETUP, value);
  }

  private static final class TestSubSetup extends TestSetup {
    // Empty
  }
}
