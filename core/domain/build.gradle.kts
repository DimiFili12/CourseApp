plugins {
    alias(libs.plugins.courseapp.android.library)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.core.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}