package williankl.spinnable.buildSrc

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.compose.desktop.DesktopExtension
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import williankl.spinnable.buildSrc.PluginHelper.applyCommonPlugins
import williankl.spinnable.buildSrc.PluginHelper.applyKotlinOptions
import williankl.spinnable.buildSrc.PluginHelper.applyRepositories

internal class SamplePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("org.jetbrains.kotlin.jvm")
            applyCommonPlugins()
            applyKotlinOptions()
            applyRepositories()
            applyDesktopTarget()
        }
    }
    private fun Project.applyDesktopTarget(){
        extensions.configure<ComposeExtension>(){
            extensions.configure<DesktopExtension>(){
                application {
                    mainClass = "MainKt"
                    nativeDistributions {
                        targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                        packageName = "jvm"
                        packageVersion = "1.0.0"
                    }
                }
            }
        }
    }
}