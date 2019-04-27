package io.github.henryssondaniel.teacup.core.reporting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class TestSuiteImplTest {
  private static final String NAME = "name";

  private final Collection<TestCase> testCases = Collections.emptySet();
  private final TestSuite testSuite = new TestSuiteImpl(NAME, testCases);

  @Test
  void getName() {
    assertThat(testSuite.getName()).isEqualTo(NAME);
  }

  @Test
  void getTestCases() {
    assertThat(testSuite.getTestCases()).isEqualTo(testCases);
  }
}
