package williankl.spinnable.buildSrc

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.maven
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.kotlin.dsl.findByType


internal object PluginHelper {

    fun Project.applyCommonPlugins() {
        plugins.apply("org.jmailen.kotlinter")
        plugins.apply("org.jetbrains.compose")
    }

    fun Project.applyKotlinOptions() {
        tasks.withType<KotlinCompile>().configureEach {
            kotlinOptions {
                jvmTarget = "${JavaVersion.VERSION_1_8}"
            }
        }
    }

    fun Project.applyRepositories() {
        repositories.apply {
            maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
            mavenCentral()
            google()
            gradlePluginPortal()
        }
    }

    fun Project.setupAndroidLibConfig() {
        findAndroidExtension()
            .setupAndroid()
    }

    fun BaseExtension.setupAndroid(){
        compileSdkVersion(31)

        defaultConfig{
            minSdk = 23
            targetSdk = 31
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        buildFeatures.apply {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.3.0-rc02"
        }
    }

    fun Project.findAndroidExtension(): BaseExtension =
        extensions.findByType<LibraryExtension>()
        ?: extensions.findByType<com.android.build.gradle.AppExtension>()
        ?: error("Could not found Android application or library plugin applied on module $name")

}