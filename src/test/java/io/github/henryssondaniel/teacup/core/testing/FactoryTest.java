package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createTestCase() {
    assertThat(Factory.createData(null, null, null)).isExactlyInstanceOf(DataImpl.class);
  }

  @Test
  void createTestResult() {
    assertThat(Factory.createResult(null, null)).isExactlyInstanceOf(ResultImpl.class);
  }

  @Test
  void createTestSuite() {
    assertThat(Factory.createPlan(Collections.emptyList())).isExactlyInstanceOf(PlanImpl.class);
  }
}
