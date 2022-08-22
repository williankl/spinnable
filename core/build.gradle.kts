
plugins {
    id("spinnable.multiplatform")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {

            }
        }

        val commonTest by getting
    }
}
