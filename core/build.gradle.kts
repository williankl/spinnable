
plugins {
    id("spinnable.multiplatform")
}

kotlin {
    sourceSets {
        val androidMain by getting {
            dependencies{
                implementation(libs.compose.android.ui)
                implementation(libs.compose.android.foundation)
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
            }
        }

        val commonTest by getting
    }
}
