package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.testing.Node;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ReporterImplTest {
  private static final String NAME = "teacup.properties";
  private final Node node = mock(Node.class);

  @Test
  void added(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).added(node);
    verify(node).getName();
  }

  @Test
  void constructorWithEmptyProperty(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var file = new File(folder, NAME);
    assertThat(file.createNewFile()).isTrue();

    Files.writeString(file.toPath(), "reporter=");

    assertThat(getReporters(new ReporterImpl(file))).isEmpty();
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
    var file = new File(folder, NAME);
    assertThat(file.createNewFile()).isTrue();

    Files.writeString(
        file.toPath(), "reporter=io.github.henryssondaniel.teacup.core.reporting.NonExisting");

    assertThat(getReporters(new ReporterImpl(file))).isEmpty();
  }

  @Test
  void finished(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var result = mock(Result.class);
    createReporter(folder).finished(result);
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
    var logRecord = mock(LogRecord.class);
    createReporter(folder).log(logRecord);
    verify(logRecord).getMessage();
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
    createReporter(folder).started(node);
    verify(node).getName();
  }

  @Test
  void terminated(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var reporter = createReporter(folder);
    reporter.initialized(Collections.singletonList(node));
    reporter.terminated();

    verify(node, times(2)).getName();
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

  @SuppressWarnings("unchecked")
  private static Iterable<Reporter> getReporters(Reporter reporter)
      throws IllegalAccessException, NoSuchFieldException {
    var field = ReporterImpl.class.getDeclaredField("reporters");
    field.setAccessible(true);

    return (Iterable<Reporter>) field.get(reporter);
  }
}
