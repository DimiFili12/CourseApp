plugins {
    alias(libs.plugins.courseapp.android.library)
    alias(libs.plugins.courseapp.android.compose)
}

android {
    namespace = "com.example.core.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))

    implementation(libs.coil.compose)
    implementation(libs.androidx.junit.ktx)
}