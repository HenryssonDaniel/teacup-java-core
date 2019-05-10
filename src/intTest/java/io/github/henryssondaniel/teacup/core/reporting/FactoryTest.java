package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.henryssondaniel.teacup.core.testing.Status;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void getReporter() {
    var reporter = Factory.getReporter();

    var node =
        io.github.henryssondaniel.teacup.core.testing.Factory.createNode(
            "name", Collections.emptyList());

    reporter.initialize();
    reporter.initialized(Collections.singletonList(node));
    reporter.log(new LogRecord(Level.INFO, "message"), node);
    reporter.started(node);
    reporter.skipped(node, "reason");
    reporter.finished(
        node,
        io.github.henryssondaniel.teacup.core.testing.Factory.createResult(
            Status.SUCCESSFUL, null));
    reporter.terminated();

    assertThat(reporter).isExactlyInstanceOf(ReporterImpl.class);
  }
}
