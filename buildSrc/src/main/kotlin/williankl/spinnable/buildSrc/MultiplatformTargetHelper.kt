package williankl.spinnable.buildSrc

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import williankl.spinnable.buildSrc.PluginHelper.findAndroidExtension
import williankl.spinnable.buildSrc.PluginHelper.setupAndroid


internal object MultiplatformTargetHelper {

    fun Project.setupMultiplatformTargets() {
        applyAndroidTarget()
        applyDesktopTarget()
        applyIOSTarget()
    }

    private fun Project.applyIOSTarget(){
        // TODO()
    }

    private fun Project.applyAndroidTarget(){
        findAndroidExtension().apply {
            sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
            setupAndroid()
        }

        extensions.configure<KotlinMultiplatformExtension>() {
            android()
        }
    }


    private fun Project.applyDesktopTarget(){
        extensions.configure<KotlinMultiplatformExtension>() {
            jvm("desktop") {
                compilations.all {
                    kotlinOptions.jvmTarget = "1.8"
                }
            }
        }
    }
}