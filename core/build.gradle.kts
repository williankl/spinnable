
plugins {
    id("spinnable.multiplatform")
    id("com.vanniktech.maven.publish")
}

kotlin {
    android { publishAllLibraryVariants() }

    sourceSets {
        val androidMain by getting {
            dependencies{
                api(libs.android.activity)
            }
        }

        val commonMain by getting {
            dependencies {
                compileOnly(compose.foundation)
                compileOnly(compose.ui)
            }
        }

        val commonTest by getting
    }
}
