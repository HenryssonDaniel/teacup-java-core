package io.github.henryssondaniel.teacup.core.configuration;

import java.io.File;
import java.util.Properties;

@FunctionalInterface
interface Configure {
  Properties loadProperties(File file);
}
