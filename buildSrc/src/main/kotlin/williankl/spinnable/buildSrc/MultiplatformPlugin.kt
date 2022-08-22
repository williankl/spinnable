package williankl.spinnable.buildSrc

import org.gradle.api.Plugin
import org.gradle.api.Project
import williankl.spinnable.buildSrc.MultiplatformTargetHelper.setupMultiplatformTargets
import williankl.spinnable.buildSrc.PluginHelper.applyCommonPlugins
import williankl.spinnable.buildSrc.PluginHelper.applyKotlinOptions
import williankl.spinnable.buildSrc.PluginHelper.applyRepositories

internal class MultiplatformPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("org.jetbrains.kotlin.multiplatform")
            plugins.apply("com.android.library")
            plugins.apply("org.jetbrains.compose")
            applyCommonPlugins()
            applyKotlinOptions()
            applyRepositories()
            setupMultiplatformTargets()
        }
    }
}