package io.github.henryssondaniel.teacup.core.testing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class PlanImplTest {
  private final Collection<Case> cases = Collections.emptySet();
  private final Collection<Suite> suites = Collections.emptySet();
  private final Plan plan = new PlanImpl(cases, suites);

  @Test
  void getCases() {
    assertThat(plan.getCases()).isEqualTo(cases);
  }

  @Test
  void getSuites() {
    assertThat(plan.getSuites()).isEqualTo(suites);
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
