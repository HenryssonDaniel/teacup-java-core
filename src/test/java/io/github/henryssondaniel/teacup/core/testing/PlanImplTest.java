package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class PlanImplTest {
  private final Collection<Data> data = Collections.emptySet();
  private final Plan plan = new PlanImpl(data);

  @Test
  void getTestCases() {
    assertThat(plan.getData()).isEqualTo(data);
  }

  @Test
  void getTimeFinished() {
    assertThat(plan.getTimeFinished()).isZero();
  }

  @Test
  void getTimeStarted() {
    assertThat(plan.getTimeStarted()).isZero();
  }

  @Test
  void setAndGetTimeFinished() {
    var timeFinished = 1L;
    plan.setTimeFinished(timeFinished);
    assertThat(plan.getTimeFinished()).isSameAs(timeFinished);
  }

  @Test
  void setAndGetTimeStarted() {
    var timeStarted = 1L;
    plan.setTimeStarted(timeStarted);
    assertThat(plan.getTimeStarted()).isSameAs(timeStarted);
  }
}
