package io.github.henryssondaniel.teacup.core.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ConfigureImplTest {
  private final Configure configure = new ConfigureImpl();

  @Test
  void initializeWithFolder(@TempDir File file) {
    assertThat(configure.loadProperties(file)).isEmpty();
  }

  @Test
  void loadProperties(@TempDir File folder) throws IOException {
    var file = new File(folder, "name");
    assertThat(file.createNewFile()).isTrue();

    assertThat(configure.loadProperties(file)).isEmpty();
  }

  @Test
  void loadPropertiesWithNonExistingFile() {
    var file = mock(File.class);
    assertThat(configure.loadProperties(file)).isEmpty();
  }
}
