package org.teacup.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.ObjectAssert;

class DefaultNodeBuilderTest {
  private static final String ACTUAL = "actual";

  @Mock private Node<String> setter;
  @Mock private Node<String> setterNew;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void build() {
    NodeBuilder<String, Node<String>, TestDefaultNodeBuilder> defaultNodeBuilder =
        new TestDefaultNodeBuilder(setter, setterNew);

    assertThat(defaultNodeBuilder.build()).isSameAs(setter);
    assertThat(defaultNodeBuilder.build()).isSameAs(setterNew);
  }

  @Test
  void getSetter() {
    assertThat(new TestDefaultNodeBuilder(setter, setterNew).getSetter()).isSameAs(setter);
  }

  @Test
  void setAssertion() {
    NodeBuilder<String, Node<String>, TestDefaultNodeBuilder> defaultNodeBuilder =
        new TestDefaultNodeBuilder(setter, setterNew);
    assertThat(defaultNodeBuilder.setAssertion(null)).isSameAs(defaultNodeBuilder);
    verify(setterNew).verify(ACTUAL);
  }

  private static final class TestDefaultNodeBuilder
      extends DefaultNodeBuilder<String, Node<String>, Node<String>, TestDefaultNodeBuilder> {
    private final Node<String> setterNew;

    private TestDefaultNodeBuilder(Node<String> setter, Node<String> setterNew) {
      super(setter);
      this.setterNew = setterNew;
    }

    @Override
    protected Node<String> createSetter() {
      return setterNew;
    }

    @Override
    protected void doAssertion(ObjectAssert<String, ?> assertion) {
      setterNew.verify(ACTUAL);
    }
  }
}
