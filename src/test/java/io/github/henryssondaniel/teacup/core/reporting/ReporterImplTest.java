package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;

class ReporterImplTest {
  private final LogRecord logRecord = mock(LogRecord.class);
  private final Node node = mock(Node.class);
  private final Result result = mock(Result.class);

  @Test
  void finished() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter();

    reporter.started(node);
    verify(node).getName();

    reporter.finished(node, result);

    verify(result).getStatus();
    assertThat(getRunningTests(reporter)).isEmpty();
  }

  @Test
  void finishedWhenMultipleRunningNodes() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter();

    reporter.started(node);
    verify(node).getName();

    var testNode = mock(Node.class);
    reporter.started(testNode);
    verify(testNode).getName();

    reporter.finished(node, result);
    verify(result).getStatus();

    var map = getRunningTests(reporter);
    assertThat(map).hasSize(1);
    map.forEach((key, value) -> assertThat(value).containsExactly(testNode));
  }

  @Test
  void finishedWhenNoReporters() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter("");
    reporter.finished(node, result);
    verifyZeroInteractions(result);
  }

  @Test
  void finishedWhenNotStarted() throws IllegalAccessException, NoSuchFieldException {
    createReporter().finished(node, result);
    verify(result).getStatus();
  }

  @Test
  void initializeWithEmptyProperty() throws IllegalAccessException, NoSuchFieldException {
    createReporter("");
  }

  @Test
  void initializeWithNonExistingReporter() throws IllegalAccessException, NoSuchFieldException {
    createReporter("io.github.henryssondaniel.teacup.core.reporting.NonExisting");
  }

  @Test
  void initializeWithNullProperty() throws IllegalAccessException, NoSuchFieldException {
    createReporter(null);
  }

  @Test
  void initialized() throws IllegalAccessException, NoSuchFieldException {
    createReporter().initialized(Collections.singletonList(node));
    verify(node).getName();
  }

  @Test
  void log() throws IllegalAccessException, NoSuchFieldException {
    createReporter().log(logRecord, node);

    verify(logRecord).getMessage();
    verifyZeroInteractions(node);
  }

  @Test
  void logWhenNoNode() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter();

    reporter.started(node);
    verify(node).getName();

    reporter.log(logRecord, null);

    verify(logRecord).getMessage();
  }

  @Test
  void logWhenNoNodeNotStarted() throws IllegalAccessException, NoSuchFieldException {
    createReporter().log(logRecord, null);
    verify(logRecord).getMessage();
  }

  @Test
  void logWhenNoReporters() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter("");

    reporter.log(logRecord, node);

    verifyZeroInteractions(logRecord);
    verifyZeroInteractions(node);
  }

  @Test
  void skipped() throws IllegalAccessException, NoSuchFieldException {
    createReporter().skipped(node, "reason");
    verify(node).getName();
  }

  @Test
  void started() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter();
    reporter.started(node);
    verify(node).getName();

    var map = getRunningTests(reporter);
    assertThat(map).hasSize(1);
    map.forEach((key, value) -> assertThat(value).containsExactly(node));
  }

  @Test
  void startedWhenNoReporters() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter("");
    reporter.started(node);

    assertThat(getRunningTests(reporter)).isEmpty();

    verifyZeroInteractions(logRecord);
    verifyZeroInteractions(node);
  }

  @Test
  void terminated() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter();
    reporter.initialized(Collections.singletonList(node));
    reporter.terminated();

    assertThat(getRunningTests(reporter)).isEmpty();
    verify(node, times(2)).getName();
  }

  @Test
  void terminatedWhenStartedNodes() throws IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter();

    reporter.initialized(Collections.singletonList(node));
    reporter.started(node);
    reporter.terminated();

    assertThat(getRunningTests(reporter)).isEmpty();
    verify(node, times(3)).getName();
  }

  private static Reporter createReporter() throws IllegalAccessException, NoSuchFieldException {
    Reporter reporter =
        new ReporterImpl("io.github.henryssondaniel.teacup.core.reporting.DefaultReporter");
    reporter.initialize();

    var reporters = getReporters(reporter);
    assertThat(reporters).hasSize(1);
    assertThat(reporters.iterator().next()).isExactlyInstanceOf(DefaultReporter.class);

    return reporter;
  }

  private static Reporter createReporter(String content)
      throws IllegalAccessException, NoSuchFieldException {
    Reporter reporter = new ReporterImpl(content);
    reporter.initialize();

    assertThat(getReporters(reporter)).isEmpty();

    return reporter;
  }

  @SuppressWarnings("unchecked")
  private static Iterable<Reporter> getReporters(Reporter reporter)
      throws IllegalAccessException, NoSuchFieldException {
    var field = ReporterImpl.class.getDeclaredField("reporters");
    field.setAccessible(true);

    return (Iterable<Reporter>) field.get(reporter);
  }

  @SuppressWarnings("unchecked")
  private static Map<Long, LinkedList<Node>> getRunningTests(Reporter reporter)
      throws IllegalAccessException, NoSuchFieldException {
    var field = ReporterImpl.class.getDeclaredField("runningTests");
    field.setAccessible(true);

    return (Map<Long, LinkedList<Node>>) field.get(reporter);
  }
}
