package williankl.spinnable.buildSrc

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import williankl.spinnable.buildSrc.PluginHelper.applyCommonPlugins
import williankl.spinnable.buildSrc.PluginHelper.applyKotlinOptions
import williankl.spinnable.buildSrc.PluginHelper.applyRepositories
import williankl.spinnable.buildSrc.PluginHelper.setupAndroid

internal class SampleAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.apply("com.android.application")
            plugins.apply("org.jetbrains.kotlin.android")
            applyCommonPlugins()
            applyKotlinOptions()
            applyRepositories()
            setupAndroidAppConfig()
        }
    }

    private fun Project.setupAndroidAppConfig() {
        extensions.configure<BaseAppModuleExtension> {
            setupAndroid(withCompose = false)
            defaultConfig {
                applicationId = "williankl.spinnable"
                versionCode = 1
                versionName = "1.0"
            }
        }
    }
}