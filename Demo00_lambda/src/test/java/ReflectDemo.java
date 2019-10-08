import com.sun.org.apache.xpath.internal.operations.Mod;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author aswl.com
 * @version 1.0.0
 * @create 2019/10/8 9:50
 */
public class ReflectDemo {
    public static void main(String[] args) {
        // printFields();
        printMethods();
    }

    /**
     * 通过反射获取类的所有变量
     */
    public static void printFields() {
        //1.获取并输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类的名称 : " + mClass.getName());

        //2.1获取所有public访问权限的变量
        //包括本类声明和从父类继承的
        // Field[] fields = mClass.getFields();

        //获取所有本类声明的变量(不问访问权限)
        Field[] fields = mClass.getDeclaredFields();

        //3.遍历变量并输出变量信息
        for (Field field : fields) {
            //获取访问权限并输出
            int modifiers = field.getModifiers();
            System.out.println(Modifier.toString(modifiers) + " ");
            //输出变量的类型及变量名
            System.out.println(field.getType().getName() + "---" + field.getName());
        }
    }

    /**
     * 通过反射获取类的所有方法
     */
    public static void printMethods() {
        //1.获取输出类的名称
        Class mClass = SonClass.class;
        System.out.println("类名 : " + mClass.getName());
        //2.1获取所有public权限的方法
        // Method[] methods = mClass.getMethods();

        //2.2获取所有权限的方法
        Method[] methods = mClass.getDeclaredMethods();

        //3.遍历方法并输出方法信息
        for (Method method : methods) {
            //3.1获取并输出方法的访问权限(Modifiers)
            int modifiers = method.getModifiers();
            // System.out.println("访问权限 : " + Modifier.toString(modifiers));
            //3.2获取方法的返回值类型
            Class<?> returnType = method.getReturnType();
            // System.out.println(returnType.getName() + "-->" + method.getName());
            //3.3获取并输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getType().getName() + "-->" + parameter.getName() + "-->" + method.getName());
            }
        }
    }
}
