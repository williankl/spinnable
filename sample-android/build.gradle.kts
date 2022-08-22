
plugins {
    id("spinnable.sample-android")
}

dependencies {
    implementation(projects.core)
    implementation(libs.compose.android.ui)
    implementation(libs.compose.android.foundation)
    implementation(libs.compose.android.activity)
}
