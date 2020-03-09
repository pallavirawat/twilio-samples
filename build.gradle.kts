plugins {
    java
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.serialization") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
//    mavenLocal()
    mavenCentral()
    maven {
//        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/pallavirawat/kotlin-sample-library")
    }
}

dependencies {
    implementation("org.example", "kotlin-my-library", "1.0-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.twilio.sdk", "twilio", "7.42.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.14.0") // JVM dependency
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}