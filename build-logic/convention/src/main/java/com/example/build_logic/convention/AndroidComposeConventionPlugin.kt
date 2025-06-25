package com.example.build_logic.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.withPlugin("com.android.application") {
                configureAndroidCompose(extensions.getByType<ApplicationExtension>())
            }
            pluginManager.withPlugin("com.android.library") {
                configureAndroidCompose(extensions.getByType<com.android.build.api.dsl.LibraryExtension>())
            }
        }
    }
}

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {

        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion = ProjectConfig.kotlinCompilerExtension
        }

        dependencies {
            add("implementation", libs.findLibrary("compose.bom").get())
            add("implementation", libs.findLibrary("compose.ui").get())
            add("implementation", libs.findLibrary("compose.material3").get())
            add("implementation", libs.findLibrary("compose.ui.tooling.preview").get())
            add("debugImplementation", libs.findLibrary("compose.ui.tooling").get())
        }
    }
}