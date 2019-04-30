package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.testing.Container;
import io.github.henryssondaniel.teacup.core.testing.Executable;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Root;
import java.util.logging.LogRecord;

/**
 * Reporter.
 *
 * @since 1.1
 */
public interface Reporter {
  /**
   * Finished.
   *
   * @param result the result
   * @since 1.1
   */
  void finished(Result result);

  /**
   * Log.
   *
   * @param logRecord the log record
   * @since 1.1
   */
  void log(LogRecord logRecord);

  /**
   * Skipped.
   *
   * @param executable the executable
   * @param reason the reason
   * @since 1.1
   */
  void skipped(Executable executable, String reason);

  /**
   * Skipped.
   *
   * @param container the container
   * @param reason the reason
   * @since 1.1
   */
  void skipped(Container container, String reason);

  /**
   * Started.
   *
   * @param executable the executable
   * @since 1.1
   */
  void started(Executable executable);

  /**
   * Started.
   *
   * @param root the root
   * @since 1.1
   */
  void started(Root root);

  /**
   * Started.
   *
   * @param container the container
   * @since 1.1
   */
  void started(Container container);
}
