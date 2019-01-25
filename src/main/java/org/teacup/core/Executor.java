package org.teacup.core;

/**
 * Interface to handle execution.
 *
 * @since 1.0
 */
@FunctionalInterface
public interface Executor {
  /**
   * The method executes a fixture. The logic for when the fixture should be tear down or set up is
   * decided here. It is also decided how the current fixture/fixtures are going to be tear down and
   * set up.
   *
   * @param fixture the fixture
   */
  void executeFixture(Fixture fixture);
}
