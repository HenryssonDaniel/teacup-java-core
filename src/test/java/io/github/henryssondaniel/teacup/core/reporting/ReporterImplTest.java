package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.testing.Data;
import io.github.henryssondaniel.teacup.core.testing.Plan;
import io.github.henryssondaniel.teacup.core.testing.Result;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ReporterImplTest {
  private static final String NAME = "teacup.properties";

  private final Data data = mock(Data.class);
  private final Plan plan = mock(Plan.class);

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
  void finishedData(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    var result = mock(Result.class);
    createReporter(folder).finished(data, result);
    verify(data).getName();
  }

  @Test
  void finishedPlan(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).finished(plan);
    verify(plan).getTimeFinished();
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
    createReporter(folder).skipped(data, "reason");
    verify(data).getName();
  }

  @Test
  void startedData(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(data);
    verify(data).getName();
  }

  @Test
  void startedPlan(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(plan);
    verify(plan).getTimeFinished();
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
