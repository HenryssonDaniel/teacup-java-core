package org.teacup.core;

/**
 * Transport interface.
 *
 * @since 1.0
 */
public interface Transport {
  /** Set up the transport. */
  void setUp();

  /** Tear down the transport. */
  void tearDown();
}
