package io.github.henryssondaniel.teacup.core.configuration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void getProperties() {
    assertThat(Factory.getProperties()).isExactlyInstanceOf(Properties.class);
  }
}
