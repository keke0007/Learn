/**
 * @Author ke
 * @create 2019/8/22 17:09
 * @version 1.0.0
 */

import org.junit.Test;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/22 17:09
 */
public class Optional {
    /**
     * Optional 容器类: 用于尽量避免空指针异常
     * Optional.of(T t) : 创建一个Optional实例
     * Optional.empty() :创建一个空的Optional实例
     * Optional.ofNullable(T t): 若t不为null,创建Optional实例,否则创建空实例
     * isPresent() : 判断是否包含值
     * orElse(T t) : 如果调用对象包含值,返回该值,否则返回t
     * orElseGet(Supplier s) : 如果调用对象包含值,返回该值,否则返回s获取的值
     * map(Function f) : 如果有值对其处理,并返回处理后的Optional,否则返回Optional.empty()
     * flatMap(Function mapper) : 与map类似,要求返回值必须是Optional
     */
    @Test
    public void test1() {
        System.out.println("测试通过Optional.of()得到对象");
        java.util.Optional<Employee> optional = java.util.Optional.of(new Employee());
        Employee employee = optional.get();
        System.out.println(employee);
    }
}
