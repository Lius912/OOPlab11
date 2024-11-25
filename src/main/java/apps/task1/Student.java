package apps.task1;

import java.util.List;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

enum Gender {
    MALE, FEMALE
}

@Getter @SuperBuilder @ToString
public class Student extends Human {
    private String firstName;
    private String lastName;
    @Singular
    private List<Integer> grades;
    private String group;
    private int age;
    private double height;
}

