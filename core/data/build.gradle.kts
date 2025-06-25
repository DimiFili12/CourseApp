plugins {
    alias(libs.plugins.courseapp.android.library)
    alias(libs.plugins.courseapp.android.hilt)
}

android {
    namespace = "com.example.core.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:database"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(libs.androidx.junit.ktx)
}