plugins {
    kotlin("jvm") version "1.6.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation("io.ktor:ktor-client-core:1.5.4")
    implementation("io.ktor:ktor-client-cio:2.0.0")
    implementation("org.jsoup:jsoup:1.14.3")
    implementation("com.google.code.gson:gson:2.9.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application { mainClass.set("MainKt") }
