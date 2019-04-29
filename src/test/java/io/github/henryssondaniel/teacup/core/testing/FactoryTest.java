package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createCase() {
    assertThat(Factory.createCase(null, null)).isExactlyInstanceOf(CaseImpl.class);
  }

  @Test
  void createPlan() {
    assertThat(Factory.createPlan(Collections.emptyList(), Collections.emptyList()))
        .isExactlyInstanceOf(PlanImpl.class);
  }

  @Test
  void createResult() {
    assertThat(Factory.createResult(null, null)).isExactlyInstanceOf(ResultImpl.class);
  }

  @Test
  void createSuite() {
    assertThat(Factory.createSuite(Collections.emptyList(), null, Collections.emptyList()))
        .isExactlyInstanceOf(SuiteImpl.class);
  }
}
