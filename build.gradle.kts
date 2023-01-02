import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/io.kotest/kotest-runner-junit5-jvm
    testImplementation("io.kotest:kotest-runner-junit5-jvm:5.5.4")
    // https://mvnrepository.com/artifact/io.kotest/kotest-assertions-core-jvm
    testImplementation("io.kotest:kotest-assertions-core-jvm:5.5.4")

}

tasks.test {
    useJUnitPlatform()
    filter {
        //include all tests from package
        includeTestsMatching("*MyFirstTestClass.*fail*")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}