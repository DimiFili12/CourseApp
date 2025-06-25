plugins {
    alias(libs.plugins.courseapp.android.library)
    alias(libs.plugins.courseapp.android.hilt)
}

android {
    namespace = "com.example.core.database"
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.androidx.junit.ktx)
    ksp(libs.room.compiler)
}