import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0.0
 * @Author ke
 * @create 2019/8/21 11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private Integer age;
    private Double salary;
    public String show() {
        return "测试方法引用！";
    }
}
