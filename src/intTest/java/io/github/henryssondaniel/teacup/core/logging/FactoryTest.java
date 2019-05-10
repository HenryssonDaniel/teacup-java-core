package io.github.henryssondaniel.teacup.core.logging;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void getLogger() {
    verify();

    var handler = verify();
    handler.publish(new LogRecord(Level.INFO, "message"));
    handler.flush();
    handler.close();
  }

  private static Handler verify() {
    var handlers = Factory.getLogger(FactoryTest.class).getHandlers();
    assertThat(handlers).hasSize(1);
    return handlers[0];
  }
}
