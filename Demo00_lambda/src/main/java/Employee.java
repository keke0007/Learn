import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 11:20
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
}
