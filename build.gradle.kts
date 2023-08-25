plugins {
    kotlin("jvm") version "1.9.0"
    id("org.jetbrains.compose") version "1.4.3"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}


dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.compose.material:material-icons-extended-desktop:1.4.3")
    implementation("org.jetbrains.compose.material3:material3:1.2.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.compose.ui:ui-test-desktop:1.4.3")
    testImplementation("org.jetbrains.compose.ui:ui-test-junit4:1.4.3")
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
            packageVersion = "1.3.0"
            packageName = "m3-components"

            val iconsRoot = project.file("src/main/resources")

            macOS {
               iconFile.set(iconsRoot.resolve("icon.icns"))
            }
        }
    }
}
