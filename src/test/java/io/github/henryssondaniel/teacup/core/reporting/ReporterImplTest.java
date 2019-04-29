package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.testing.Case;
import io.github.henryssondaniel.teacup.core.testing.Plan;
import io.github.henryssondaniel.teacup.core.testing.Result;
import io.github.henryssondaniel.teacup.core.testing.Suite;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.LogRecord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ReporterImplTest {
  private static final String NAME = "teacup.properties";
  private static final String REASON = "reason";
  private final Plan plan = mock(Plan.class);
  private final Result result = mock(Result.class);
  private final Suite suite = mock(Suite.class);
  private final Case testCase = mock(Case.class);

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
  void skippedCase(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).skipped(REASON, testCase);
    verify(testCase).getName();
  }

  @Test
  void skippedSuite(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).skipped(REASON, suite);
    verify(suite).getTimeFinished();
  }

  @Test
  void startedData(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(testCase);
    verify(testCase).getName();
  }

  @Test
  void startedPlan(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(plan);
    verify(plan).getTimeFinished();
  }

  @Test
  void startedSuite(@TempDir File folder)
      throws IOException, IllegalAccessException, NoSuchFieldException {
    createReporter(folder).started(suite);
    verify(suite).getTimeFinished();
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
