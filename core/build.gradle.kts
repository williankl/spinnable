
plugins {
    id("spinnable.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
            }
        }

        val commonTest by getting
    }
}
