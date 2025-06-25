plugins {
    alias(libs.plugins.courseapp.android.library)
    alias(libs.plugins.courseapp.android.compose)
}

android {
    namespace = "com.example.core.designsystem"
}

dependencies {
    implementation(project(":core:model"))

    implementation(platform(libs.compose.bom))
    implementation(libs.androidx.junit.ktx)
}