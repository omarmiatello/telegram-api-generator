plugins {
    kotlin("jvm") version "1.4.31"
}

group = "com.github.omarmiatello.kt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jsoup:jsoup:1.11.3")
    implementation("com.google.code.gson:gson:2.8.5")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}