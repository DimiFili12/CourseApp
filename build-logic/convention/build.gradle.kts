import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.courseapp.android.application.get().pluginId
            implementationClass = "com.example.build_logic.convention.AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.courseapp.android.library.get().pluginId
            implementationClass = "com.example.build_logic.convention.AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = libs.plugins.courseapp.android.compose.get().pluginId
            implementationClass = "com.example.build_logic.convention.AndroidComposeConventionPlugin"
        }
        register("androidHilt") {
            id = libs.plugins.courseapp.android.hilt.get().pluginId
            implementationClass = "com.example.build_logic.convention.AndroidHiltConventionPlugin"
        }
        register("jvmLibrary") {
            id = libs.plugins.courseapp.jvm.library.get().pluginId
            implementationClass = "com.example.build_logic.convention.JvmLibraryConventionPlugin"
        }
    }
}
