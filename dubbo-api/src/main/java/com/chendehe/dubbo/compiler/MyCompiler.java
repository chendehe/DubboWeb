package com.chendehe.dubbo.compiler;

import java.lang.reflect.Method;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * @author CDH
 * @since 2019.8.13 013 0:28
 */
public class MyCompiler {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        // 创建 Hello World 类
        CtClass ctClass = classPool.makeClass("Hello World");
        // 添加 test 方法。直接传入方法的字符串
        CtMethod ctMethod = CtNewMethod.make(""
            + "public static void test() {"
            + "        System.out.println(\"Hello World\");"
            + "}", ctClass);
        ctClass.addMethod(ctMethod);
        Class aClass = ctClass.toClass();
        Object instance = aClass.newInstance();
        Method m = aClass.getDeclaredMethod("test", null);
        m.invoke(instance, null);
    }
}
