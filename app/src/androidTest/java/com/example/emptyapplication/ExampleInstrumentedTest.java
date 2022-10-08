package com.example.emptyapplication;

import android.content.Context;

import androidx.core.graphics.PathUtils;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

import static org.junit.Assert.*;
import static org.objectweb.asm.ClassWriter.COMPUTE_FRAMES;
import static org.objectweb.asm.ClassWriter.COMPUTE_MAXS;
import static org.objectweb.asm.Opcodes.*;
import static org.objectweb.asm.TypeReference.NEW;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.emptyapplication", appContext.getPackageName());
    }


//    public static void testCreateAClass()throws Exception{
//
//        //新建一个类生成器，COMPUTE_FRAMES，COMPUTE_MAXS这2个参数能够让asm自动更新操作数栈
//        ClassWriter cw=new ClassWriter(COMPUTE_FRAMES|COMPUTE_MAXS);
//        //生成一个public的类，类路径是com.study.Human
//        cw.visit(V1_8,ACC_PUBLIC,"com/study/Human",null,"java/lang/Object",null);
//
//        //生成默认的构造方法： public Human()
//        MethodVisitor mv=cw.visitMethod(ACC_PUBLIC,"<init>","()V",null,null);
//        mv.visitVarInsn(ALOAD,0);
//        mv.visitMethodInsn(INVOKESPECIAL,"java/lang/Object","<init>","()V",false);
//        mv.visitInsn(RETURN);
//        mv.visitMaxs(0,0);//更新操作数栈
//        mv.visitEnd();//一定要有visitEnd
//
//        //生成成员变量
//        //1.生成String类型的成员变量:private String name;
//        FieldVisitor fv= cw.visitField(ACC_PRIVATE,"name","Ljava/lang/String;",null,null);
//        fv.visitEnd();//不要忘记end
//        //2.生成Long类型成员：private long age
//        fv=cw.visitField(ACC_PRIVATE,"age","J",null,null);
//        fv.visitEnd();
//
//        //3.生成Int类型成员:protected int no
//        fv=cw.visitField(ACC_PROTECTED,"no","I",null,null);
//        fv.visitEnd();
//
//        //4.生成静态成员变量：public static long score
//        fv=cw.visitField(ACC_PUBLIC+ACC_STATIC,"score","J",null,null);
//
//        //5.生成常量：public static final String real_name = "Sand哥"
//        fv=cw.visitField(ACC_PUBLIC+ACC_STATIC+ACC_FINAL,"real_name","Ljava/lang/String;",null,"Sand哥");
//        fv.visitEnd();
//
//        //6.生成成员方法greet
//        mv=cw.visitMethod(ACC_PUBLIC,"greet","(Ljava/lang/String;)I",null,null);
//        mv.visitCode();
//        mv.visitIntInsn(ALOAD,0);
//        mv.visitIntInsn(ALOAD,1);
//
//        //6.1 调用静态方法 System.out.println("Hello");
//        mv.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
////        mv.visitLdcInsn("Hello");//加载字符常量
//        mv.visitIntInsn(ALOAD,1);//加载形参
//        mv.visitMethodInsn(INVOKEVIRTUAL,"java/io/PrintStream","println","(Ljava/lang/String;)V",false);//打印形参
//        //6.2 创建局部变量
//        LocalVariablesSorter lvs=new LocalVariablesSorter(ACC_PUBLIC,"(Ljava/lang/String;)I",mv);
//        //创建ArrayList 对象
//        //new ArrayList ,分配内存不初始化
//        mv.visitTypeInsn(NEW,"java/util/ArrayList");
//        mv.visitInsn(DUP);//压入栈
//        //弹出一个对象所在的地址，进行初始化操作，构造函数默认为空，此时栈大小为1（到目前只有一个局部变量）
//        mv.visitMethodInsn(INVOKESPECIAL,"java/util/ArrayList","<init>","()V",false);
//
//        int time=lvs.newLocal(Type.getType(List.class));
//
//        mv.visitVarInsn(ASTORE,time);
//        mv.visitVarInsn(ALOAD,time);
//
//        //创建StringBuilder对象
//        mv.visitTypeInsn(NEW,"java/lang/StringBuilder");
//        mv.visitInsn(DUP);
//        mv.visitMethodInsn(INVOKESPECIAL,"java/lang/StringBuilder","<init>","()V",false);
//
//        //这里需要注意在lvs.newLocal的时候使用Type.geteType("类路径") 会报错，需要改成Type.geteType("XXX.class“)的方式
//        time=lvs.newLocal(Type.getType(StringBuilder.class));
//        mv.visitVarInsn(ASTORE,time);
//        mv.visitVarInsn(ALOAD,time);
//
//        mv.visitLdcInsn("Hello java asm StringBuilder");
//        mv.visitMethodInsn(INVOKEVIRTUAL,"java/lang/StringBuilder","append","(Ljava/lang/String;)Ljava/lang/StringBuilder;",false);
//
//        mv.visitMethodInsn(INVOKESTATIC,"java/lang/System","nanoTime","()J",false);
//        time=lvs.newLocal(Type.LONG_TYPE);
//        mv.visitVarInsn(LSTORE,time);
//        mv.visitLdcInsn(10);
//        mv.visitLdcInsn(11);
//        mv.visitInsn(IADD);
//        mv.visitInsn(IRETURN);
//        mv.visitMaxs(0,0);
//        mv.visitEnd();
//
//        //生成静态方法
//        mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "staticMethod", "(Ljava/lang/String;)V", null, null);
//        //生成静态方法中的字节码指令
//        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//        mv.visitLdcInsn("Hello Java Asm!");
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//        mv.visitInsn(RETURN);
//        mv.visitMaxs(0, 0);
//        mv.visitEnd();
//
//        //设置必要的类路径
//        String path= PathUtils.getCurrentClassPath(DemoMain.class)+ File.separator+"Human.class";
//        //获取类的byte数组
//        byte[] classByteData=cw.toByteArray();
//        //把类数据写入到class文件,这样你就可以把这个类文件打包供其他的人使用
//        IOUtils.write(classByteData,new FileOutputStream(path));
//        System.err.println("类生成的位置:"+path);
//    }
    //作者：Sand
    //链接：https://juejin.cn/post/7084911979281776647
    //来源：稀土掘金
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}