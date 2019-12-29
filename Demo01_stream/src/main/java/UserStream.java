import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserStream {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(
                new User("张三", 20),
                new User("李四", 10),
                new User("王五", 30));
//        list.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user.getAge()));
//       List<User> list1 =  list.stream()
//                .map(user -> new User("test",user.getAge()))
//                .collect(Collectors.toList());
//        System.out.println(list1);
        List<User> list1 = list.stream()
                .map(user -> {
                    User obj = new User();
                    obj.setName(user.getName());
                    obj.setAge(user.getAge());
                    return obj;
                })
                .collect(Collectors.toList());
        System.out.println(list1);

    }

}
