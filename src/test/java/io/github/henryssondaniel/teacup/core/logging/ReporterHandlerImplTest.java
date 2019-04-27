package io.github.henryssondaniel.teacup.core.logging;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;

class ReporterHandlerImplTest {
  private final Handler handler = new ReporterHandlerImpl();

  @Test
  void publish() {
    var logRecord = mock(LogRecord.class);

    handler.publish(logRecord);
    handler.flush();
    handler.close();

    verifyZeroInteractions(logRecord);
  }
}
