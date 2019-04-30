package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.testing.Container;
import io.github.henryssondaniel.teacup.core.testing.Executable;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Root;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ReporterImplTest {
  private static final String NAME = "teacup.properties";
  private static final String REASON = "reason";

  private final Container container = mock(Container.class);
  private final Executable executable = mock(Executable.class);
  private final Result result = mock(Result.class);
  private final Root root = mock(Root.class);

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
    createReporter(folder).finished(result);
    verify(result).getStatus();
  }

  @Test
  void log(@TempDir File folder) throws IOException, IllegalAccessException, NoSuchFieldException {
    var logRecord = mock(LogRecord.class);
    createReporter(folder).log(logRecord);
    verify(logRecord).getMessage();
  }

  @Test
  void skippedContainer(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).skipped(container, REASON);
    verify(container).getTimeFinished();
  }

  @Test
  void skippedExecutable(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).skipped(executable, REASON);
    verify(executable).getName();
  }

  @Test
  void startedContainer(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(container);
    verify(container).getTimeFinished();
  }

  @Test
  void startedExecutable(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(executable);
    verify(executable).getName();
  }

  @Test
  void startedRoot(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(root);
    verify(root).getTimeFinished();
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
