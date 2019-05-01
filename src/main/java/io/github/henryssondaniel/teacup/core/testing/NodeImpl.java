package io.github.henryssondaniel.teacup.core.testing;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

class NodeImpl implements Node {
  private static final Logger LOGGER = Factory.getLogger(NodeImpl.class);

  private final String name;
  private final Collection<Node> nodes = new LinkedHashSet<>(0);

  private long timeFinished;
  private long timeStarted;

  NodeImpl(String name, Collection<Node> nodes) {
    this.nodes.addAll(nodes);
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Iterable<Node> getNodes() {
    LOGGER.log(Level.FINE, "Get nodes");
    return new LinkedHashSet<>(nodes);
  }

  @Override
  public long getTimeFinished() {
    return timeFinished;
  }

  @Override
  public long getTimeStarted() {
    return timeStarted;
  }

  @Override
  public void setTimeFinished(long timeFinished) {
    this.timeFinished = timeFinished;
  }

  @Override
  public void setTimeStarted(long timeStarted) {
    this.timeStarted = timeStarted;
  }
}
