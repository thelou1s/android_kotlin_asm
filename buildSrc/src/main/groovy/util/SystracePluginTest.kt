package util

import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("UNNECESSARY_SAFE_CALL")
class SystracePluginTest : Plugin<Project> {
    override fun apply(project: Project) {
        when {
            project.plugins.hasPlugin("com.android.application") -> {
                val extension = project.extensions.getByName ("android") /*as AppExtension*/
                extension?.let {
                    //it.registerTransform(TestTransFormO)
                    println("thelou1s123")
                }
            }
        }
    }
}