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

    val majorVersion = 1
    val minorVersion = 0
    val patchVersion = 0
    val fullVersion = "$majorVersion.$minorVersion.$patchVersion"


    fun Project.applyCommonPlugins() {
        plugins.apply("org.jmailen.kotlinter")
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
            .setupAndroid(withCompose = true)
    }

    fun BaseExtension.setupAndroid(withCompose: Boolean){
        compileSdkVersion(32)

        viewBinding {
            isEnabled = true
        }

        defaultConfig{
            minSdk = 23
            targetSdk = 31
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        if(withCompose){
            buildFeatures.apply {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = "1.2.0"
            }
        }
    }

    fun Project.findAndroidExtension(): BaseExtension =
        extensions.findByType<LibraryExtension>()
        ?: extensions.findByType<com.android.build.gradle.AppExtension>()
        ?: error("Could not found Android application or library plugin applied on module $name")

}