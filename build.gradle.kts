plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = project.property("projectGroup")!!
version = project.property("projectVersion")!!

dependencies {
    compileOnly(libs.spigot.api)
    compileOnly(libs.paper.api)
    implementation(frameworks.foundation) {
        exclude("org.mineacademy.plugin", "*")
        exclude("org.spigotmc", "*")
    }
    implementation(frameworks.guice.core)
}

tasks {
    shadowJar {
        archiveClassifier.set("")
        if (project.hasProperty("outputDir")) {
            destinationDirectory.set(file("${project.rootProject.properties["outputDir"]}"))
        }
        relocate("org.mineacademy.fo", "${project.rootProject.group}.${project.rootProject.name.lowercase()}.lib")
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }

    test {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(17)
}