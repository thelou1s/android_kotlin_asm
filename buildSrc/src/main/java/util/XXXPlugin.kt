package util

//import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author ganmin.he
 * @date 2022/1/5
 */
class XXXPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("Welcome to xxx plugin...")
//        val ext = project.extensions.getByType(BaseExtension::class.java)
//        ext.registerTransform(XXXTransform(project))
    }
}
//原文链接：https://blog.csdn.net/hegan2010/article/details/122341639