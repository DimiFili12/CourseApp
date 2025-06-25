plugins {
    alias(libs.plugins.courseapp.android.library)
    alias(libs.plugins.courseapp.android.compose)
    alias(libs.plugins.courseapp.android.hilt)
}

android {
    namespace = "com.example.feature.courselist"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:common"))

    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.coil.compose)
    implementation(libs.androidx.junit.ktx)
}