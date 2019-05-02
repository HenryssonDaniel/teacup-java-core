package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ReporterImplTest {
  private static final String NAME = "teacup.properties";

  private final LogRecord logRecord = mock(LogRecord.class);
  private final Node node = mock(Node.class);
  private final Result result = mock(Result.class);

  @Test
  void added(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).added(node);
    verify(node).getName();
  }

  @Test
  void constructorWithEmptyProperty(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter("reporter=", folder);
  }

  @Test
  void constructorWithFolder(@TempDir File folder)
      throws IllegalAccessException, NoSuchFieldException {
    assertThat(getReporters(new ReporterImpl(folder))).isEmpty();
  }

  @Test
  void constructorWithNonExistingFile() throws IllegalAccessException, NoSuchFieldException {
    var file = mock(File.class);
    assertThat(getReporters(new ReporterImpl(file))).isEmpty();
  }

  @Test
  void constructorWithNonExistingReporter(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter("reporter=io.github.henryssondaniel.teacup.core.reporting.NonExisting", folder);
  }

  @Test
  void finished(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter(folder);

    reporter.started(node);
    verify(node).getName();

    reporter.finished(node, result);

    verify(result).getStatus();
    assertThat(getRunningTests(reporter)).isEmpty();
  }

  @Test
  void finishedWhenMultipleRunningNodes(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter(folder);

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
  void finishedWhenNoReporters(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter("reporter=", folder);
    reporter.finished(node, result);
    verifyZeroInteractions(result);
  }

  @Test
  void finishedWhenNotStarted(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).finished(node, result);
    verify(result).getStatus();
  }

  @Test
  void initialized(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).initialized(Collections.singletonList(node));
    verify(node).getName();
  }

  @Test
  void log(@TempDir File folder) throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).log(logRecord, node);

    verify(logRecord).getMessage();
    verifyZeroInteractions(node);
  }

  @Test
  void logWhenNoReporters(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter("reporter=", folder);

    reporter.log(logRecord, node);

    verifyZeroInteractions(logRecord);
    verifyZeroInteractions(node);
  }

  @Test
  void skipped(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).skipped(node, "reason");
    verify(node).getName();
  }

  @Test
  void started(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter(folder);
    reporter.started(node);
    verify(node).getName();

    var map = getRunningTests(reporter);
    assertThat(map).hasSize(1);
    map.forEach((key, value) -> assertThat(value).containsExactly(node));
  }

  @Test
  void startedWhenNoReporters(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter("reporter=", folder);
    reporter.started(node);

    assertThat(getRunningTests(reporter)).isEmpty();

    verifyZeroInteractions(logRecord);
    verifyZeroInteractions(node);
  }

  @Test
  void terminated(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter(folder);
    reporter.initialized(Collections.singletonList(node));
    reporter.terminated();

    assertThat(getRunningTests(reporter)).isEmpty();
    verify(node, times(2)).getName();
  }

  @Test
  void terminatedWhenStartedNodes(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter(folder);

    reporter.initialized(Collections.singletonList(node));
    reporter.started(node);
    reporter.terminated();

    assertThat(getRunningTests(reporter)).isEmpty();
    verify(node, times(3)).getName();
  }

  private static Reporter createReporter(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var file = new File(folder, NAME);
    assertThat(file.createNewFile()).isTrue();

    Files.writeString(
        file.toPath(), "reporter=io.github.henryssondaniel.teacup.core.reporting.DefaultReporter");

    Reporter reporter = new ReporterImpl(file);

    var reporters = getReporters(reporter);
    assertThat(reporters).hasSize(1);
    assertThat(reporters.iterator().next()).isExactlyInstanceOf(DefaultReporter.class);

    return reporter;
  }

  private static Reporter createReporter(CharSequence content, File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var file = new File(folder, NAME);
    assertThat(file.createNewFile()).isTrue();

    Files.writeString(file.toPath(), content);

    Reporter reporter = new ReporterImpl(file);
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
