package io.github.henryssondaniel.teacup.core;

interface TestServer extends Server {
  boolean isSetUp();

  boolean isTearDown();
}
