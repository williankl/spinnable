plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins.register("multiplatform-module") {
        id = "spinnable.multiplatform"
        implementationClass = "williankl.spinnable.buildSrc.MultiplatformPlugin"
    }
    plugins.register("sample-module") {
        id = "spinnable.sample"
        implementationClass = "williankl.spinnable.buildSrc.SamplePlugin"
    }
    plugins.register("sample-android-module") {
        id = "spinnable.sample-android"
        implementationClass = "williankl.spinnable.buildSrc.SampleAndroidPlugin"
    }
}

dependencies {
    implementation(libs.plugin.vannitktechMaven)
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.multiplatform.compose)
    implementation(libs.plugin.ktlint)
}