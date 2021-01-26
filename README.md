# <a href="https://retest.dev"><img src="https://assets.retest.org/retest/ci/logos/recheck-screen.svg" width="300"/></a>

[![Build Status](https://travis-ci.com/retest/recheck-web-archetype.svg?branch=master)](https://travis-ci.com/retest/recheck-web-archetype)
[![Latest recheck-web-archetype on Maven Central](https://maven-badges.herokuapp.com/maven-central/de.retest/recheck-web-archetype/badge.svg?style=flat)](https://mvnrepository.com/artifact/de.retest/recheck-web-archetype)
[![license](https://img.shields.io/badge/license-AGPL-brightgreen.svg)](https://github.com/retest/recheck-web-archetype/blob/master/LICENSE)
[![PRs welcome](https://img.shields.io/badge/PRs-welcome-ff69b4.svg)](https://github.com/retest/recheck-web-archetype/issues?q=is%3Aissue+is%3Aopen+label%3A%22help+wanted%22)
[![code with hearth by retest](https://img.shields.io/badge/%3C%2F%3E%20with%20%E2%99%A5%20by-retest-C1D82F.svg)](https://retest.de/)

Maven Archetype for [recheck-web](https://github.com/retest/recheck-web).

## Features

Provides a maven archetype to generate a sample project using [recheck-web](https://github.com/retest/recheck-web) and [reckeck-junit-jupiter-extension](https://github.com/retest/recheck-junit-jupiter-extension).

## Advantages

Speeds up your start with [recheck](https://github.com/retest/recheck) and [recheck-web](https://github.com/retest/recheck-web).

## Usage

Most IDEs support creating a new maven project using an archetype, e.g. [eclipse](https://www.simplilearn.com/tutorials/maven-tutorial/maven-project-in-eclipse) or [IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html).

Another option is to use the maven cli. Enter following command

```sh
mvn archetype:generate -Dfilter=de.retest:
```

and set the values for your project, e.g. like below.

```
% mvn archetype:generate -Dfilter=de.retest:
...
[INFO] Generating project in Interactive mode
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
Choose archetype:
1: remote -> de.retest:recheck-web-archetype (Archetype to quick start a recheck-web project.)
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): : 1
Define value for property 'groupId': my.company
Define value for property 'artifactId': mytestproject
Define value for property 'version' 1.0-SNAPSHOT: :
Define value for property 'package' my.company: :
Confirm properties configuration:
groupId: my.company
artifactId: mytestproject
version: 1.0-SNAPSHOT
package: my.company
 Y: :
[INFO] ----------------------------------------------------------------------------
...
```

## License

This project is licensed under the [AGPL license](LICENSE).
