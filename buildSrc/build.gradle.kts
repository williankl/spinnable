plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

gradlePlugin {
    plugins.register("multiplatform-module") {
        id = "spinnable.multiplatform"
        implementationClass = "williankl.spinnable.buildSrc.MultiplatformPlugin"
    }

    plugins.register("sample") {
        id = "spinnable.sample"
        implementationClass = "williankl.spinnable.buildSrc.SamplePlugin"
    }
}

dependencies {
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.multiplatform.compose)
    implementation(libs.plugin.ktlint)
}