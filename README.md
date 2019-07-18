# [User Guide](https://henryssondaniel.github.io/teacup.github.io/)
[![Build Status](https://travis-ci.com/HenryssonDaniel/teacup-java-core.svg?branch=master)](https://travis-ci.com/HenryssonDaniel/teacup-java-core)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=HenryssonDaniel_teacup-java-core&metric=coverage)](https://sonarcloud.io/dashboard?id=HenryssonDaniel_teacup-java-core)
[![latest release](https://img.shields.io/badge/release%20notes-1.1.2-yellow.svg)](https://github.com/HenryssonDaniel/teacup-java-core/blob/master/doc/release-notes/official.md)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.henryssondaniel.teacup/core.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22io.github.henryssondaniel.teacup%22%20AND%20a%3A%22core%22)
[![Javadocs](https://www.javadoc.io/badge/io.github.henryssondaniel.teacup/core.svg)](https://www.javadoc.io/doc/io.github.henryssondaniel.teacup/core)
## What ##
The core project has three main responsibilities and does not rely on any special test engine or
protocol:  

**Assertions**  
A big library with all the base assertions such as arrays, lists and primitives.

**Interfaces**  
Interfaces such as Executor, Node and Server.

**Setup**  
Support for fixtures and other setup-related functionality.
## Why ##
The framework does not rely on any specific test engine or protocol.  
It is built to be able to be easy to use, extend and maintain.
## How ##
This is possible due to highly use of interfaces and almost none of the implementation classes are
exposed to the public.  

The core project does not know anything about the test engine or protocols implemented, which makes
the project very isolated.