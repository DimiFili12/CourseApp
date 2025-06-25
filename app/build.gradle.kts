plugins {
    alias(libs.plugins.courseapp.android.application)
    alias(libs.plugins.courseapp.android.compose)
    alias(libs.plugins.courseapp.android.hilt)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.courseapp"

    defaultConfig {
        applicationId = "com.example.courseapp"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":feature:courselist"))
    implementation(project(":feature:coursedetails"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.androidx.junit.ktx)
    ksp(libs.hilt.compiler)

    implementation(libs.compose.activity)
    implementation(libs.compose.navigation)
    implementation(libs.compose.material3)
    testImplementation(kotlin("test"))
}