package util

//import com.android.build.api.transform.*
import org.gradle.api.Project
import java.io.File
import java.io.FileOutputStream
import java.util.jar.JarEntry
import java.util.jar.JarFile
import java.util.jar.JarOutputStream

/**
 * @author ganmin.he
 * @date 2022/1/5
 */
class TrackTransform(project: Project) : BaseTransform(project) {
//    companion object {
//        private const val TARGET = "a/b/c/Target.class"
//        private val TARGETS = arrayOf(TARGET)
//    }
//
//    override fun getName(): String = "xxx"
//
//    override fun doTransformJar(jarInput: JarInput, destOutput: File): Boolean {
//        JarFile(jarInput.file).use { jarFile ->
//            val entries = jarFile.entries().toList()
//            val filter = entries.filter {
//                TARGETS.contains(it.name)
//            }
//            if (filter.isEmpty()) return false
//            // Write the modified bytecode directly to destOutput.
//            JarOutputStream(FileOutputStream(destOutput)).use { jos ->
//                entries.forEach { other ->
//                    if (filter.contains(other)) return@forEach
//                    jos.putNextEntry(JarEntry(other.name))
//                    jarFile.getInputStream(other).use {
//                        jos.write(it.readAllBytes())
//                    }
//                    jos.closeEntry()
//                }
//
//                filter.forEach { targetEntry ->
//                    log("found ${targetEntry.name} in ${jarInput.file}")
//                    jos.putNextEntry(JarEntry(targetEntry.name))
//                    jarFile.getInputStream(targetEntry).use {
//                        when (targetEntry.name) {
//                            TARGET -> ModifyTarget.modifyByteCode(it)
//                            else -> it.readAllBytes()
//                        }
//                    }.let {
//                        jos.write(it)
//                    }
//                    jos.closeEntry()
//                }
//
//                log("write to $destOutput")
//            }
//            return true
//        }
//    }
//
//    override fun doTransformFile(fileInput: File, destOutput: File): Boolean = false
}
//原文链接：https://blog.csdn.net/hegan2010/article/details/122341639