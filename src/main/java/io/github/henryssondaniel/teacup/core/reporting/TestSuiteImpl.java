package io.github.henryssondaniel.teacup.core.reporting;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestSuiteImpl implements TestSuite {
  private static final Logger LOGGER = Factory.getLogger(TestSuiteImpl.class);

  private final String name;
  private final Set<TestCase> testCases = new LinkedHashSet<>(0);

  TestSuiteImpl(String name, Collection<TestCase> testCases) {
    this.name = name;
    this.testCases.addAll(testCases);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Iterable<TestCase> getTestCases() {
    LOGGER.log(Level.FINE, "Get test cases");
    return new LinkedHashSet<>(testCases);
  }
}
