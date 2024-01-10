package hellomvc.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter //lombok으로 getter setter 자동 생성해줌
public class HelloData {
    private String username;
    private int age;

}
