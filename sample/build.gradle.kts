
plugins {
    id("spinnable.sample")
}

dependencies {
    implementation(projects.core)
    implementation(compose.foundation)
    implementation(compose.desktop.currentOs)
}
