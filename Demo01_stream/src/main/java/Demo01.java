import java.util.Arrays;
import java.util.List;

public class Demo01 {
    public static void main(String[] args) {

        // old way
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        for(Integer n : list) {
            int x = n * n;
            System.out.print(x + " ");
        }
        System.out.println("=====================");
        // new way
        List<Integer> list_new = Arrays.asList(1,2,3,4,5,6,7);
        list_new.stream().map((x) -> x*x).forEach(n -> System.out.print(n + " "));
    }
}
