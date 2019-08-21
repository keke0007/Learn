public class Demo00 {
    public static void main(String[] args) {
//        Lambda表达式的结构
//------->Lambda表达式可以具有零个,一个或多个参数
//------->可以显示声明参数的类型,也可以由编译器自动从上下文推断参数的类型.例如(int a)
//        与刚才形同(a)
//------->参数用小括号括起来,用逗号分隔,例如(a,b)或(int a,int b)或(String a,int b,float c)
//------->空括号用于表示一组空的参数,例如() ->42
//------->当有且仅有一个参数时,如果不显示指明类型,则不必使用小括号,例如a -> return a*a
//------->Lambda表达式的正文可以包含零条,一条或多条语句
//------->如果Lambda表达式的正文只有一条语句,则大括号可不用写,且表达式的返回值类型要与
//        匿名函数的返回类型相同
//------->如果Lambda表达式的正文有一条以上的语句必须包含在大括号(代码块),且表达式的返回
//        值类型要与匿名函数的返回类型相同
//
//

//        方法引用
//        双冒号(::)操作符是java中的方法引用,当我们使用一个方法的引用时,目标引用放在
//        ::之前,目标引用提供的方法名称放在::之后.即目标引用::方法.比如
//        Person::getAge;
//        在Person类中定义的方法getAge的方法引用

//
//        功能接口(Functional interface)
//        在java中,功能接口(Functional interface)指只有一个抽象方法的接口
//        java.lang.Runnable是一个功能接口,在Runnable中只有一个方法的声明void run()
//        我们使用匿名内部类实例化功能接口的对象,而使用Lambda表达式,可以简化写法
//        每个Lambda表达式都可以隐式地分配给功能接口,例如,我们可以从Lambda表达式创建
//        Runnable接口的引用,
//        Runnable r = () -> System.out.println("Hello World")
//        当我们不指定功能接口时,这种类型的转换会被编译器自动处理,例如
//        new Thread(
//          () -> System.out.println("Hello World")
//        ).start();
//
//
//
    }
}
