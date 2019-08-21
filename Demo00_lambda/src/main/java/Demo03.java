import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 11:19
 */
public class Demo03 {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("张三", 18, 999.99));
        list.add(new Employee("李四", 25, 66666.99));
        list.add(new Employee("王五", 30, 99999.99));
        list.add(new Employee("赵六", 33, 33333.99));
        list.add(new Employee("田七", 40, 77777.99));
       Collections.sort(list,(o1,o2) ->{
            if (o1.getAge() == o2.getAge()) {
                return o2.getName().compareTo(o1.getName());
            } else {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        list.forEach(System.out::println);
    }
}
