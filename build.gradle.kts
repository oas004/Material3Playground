plugins {
    kotlin("jvm") version "2.2.20"
    id("org.jetbrains.compose") version "1.9.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.10"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.compose.material:material-icons-extended-desktop:1.9.0")
    implementation("org.jetbrains.compose.material3:material3:1.9.0")

    // Compose 1.9.x may pull a newer kotlinx-datetime; add explicit dependency to avoid
    // resolution conflicts if used elsewhere in the project.
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.7.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.compose.ui:ui-test-desktop:1.9.0")
    testImplementation("org.jetbrains.compose.ui:ui-test-junit4:1.9.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            modules("java.sql")
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
            )
            packageVersion = "1.6.0"
            packageName = "m3-components"

            val iconsRoot = project.file("src/main/resources")

            macOS {
               iconFile.set(iconsRoot.resolve("icon.icns"))
            }
        }
    }
}