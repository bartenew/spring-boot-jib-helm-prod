/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * User Manual available at https://docs.gradle.org/6.4.1/userguide/tutorial_java_projects.html
 */

plugins {
  id("org.springframework.boot") version "2.2.0.RELEASE" apply false
  id("io.spring.dependency-management") version "1.0.8.RELEASE" apply false
  id("com.google.cloud.tools.jib") version "2.3.0" apply false
  id("net.nemerosa.versioning") version "2.8.2"
}

allprojects {
  repositories {
    mavenCentral()
    jcenter()
  }
  group = "me.bartenew"
  version = "1.0.0"
}
subprojects {
  apply {
    plugin("io.spring.dependency-management")
    plugin("com.google.cloud.tools.jib")
    plugin("org.springframework.boot")
    plugin("net.nemerosa.versioning")
  }
  extra.apply {
    set("docker.tag", "${project.version}-${versioning.info.build}")
  }
}
