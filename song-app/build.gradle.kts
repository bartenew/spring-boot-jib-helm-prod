plugins {
  java
}
dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
}

jib.to.image = """bartenew/${project.name}-${extra["docker.tag"]}"""
