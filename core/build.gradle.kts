
plugins {
    id("spinnable.multiplatform")
    id("com.vanniktech.maven.publish")
}

kotlin {
    android { publishAllLibraryVariants() }

    sourceSets {
        val androidMain by getting {
            dependencies{
                implementation(libs.compose.android.ui)
                implementation(libs.compose.android.foundation)
                implementation(libs.android.activity)
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
