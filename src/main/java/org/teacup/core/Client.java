package org.teacup.core;

import java.util.concurrent.CompletableFuture;

/**
 * Client interface.
 *
 * @since 1.0
 */
public interface Client<T, U, V> {
  /**
   * Sends a request.
   *
   * @param handler the handler
   * @param request the request
   * @return the response
   */
  V send(T handler, U request);
  /**
   * Sends a request asynchronously.
   *
   * @param handler the handler
   * @param request the request
   * @return the completable future response
   */
  CompletableFuture<V> sendAsynchronously(T handler, U request);
}
