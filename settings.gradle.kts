@file:Suppress("UnstableApiUsage")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = getProperty("projectName")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven {
            name = "spigotmc-repo"
            url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        }
        maven {
            name = "papermc-repo"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
        maven {
            name = "sonatype"
            url = uri("https://oss.sonatype.org/content/groups/public/")
        }
        maven {
            name = "jitpack.io"
            url = uri("https://jitpack.io")
        }
    }

    versionCatalogs {
        create("libs") {
            library("spigot-api", "org.spigotmc:spigot-api:${getProperty("bukkitVersion")}")
            library("paper-api", "io.papermc.paper:paper-api:${getProperty("bukkitVersion")}")
        }

        create("frameworks") {
            library("foundation", "com.github.kangarko:Foundation:${getProperty("foundationVersion")}")
            library("guice-core", "com.google.inject:guice:${getProperty("guiceVersion")}")
        }
    }
}

fun getProperty(key: String): String {
    return extra.get(key)?.toString() ?: throw IllegalArgumentException("property with $key not found")
}