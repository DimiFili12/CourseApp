plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.kotlinx.coroutines)
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)
}
