package apps.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student student =  Student.builder()
        .firstName("John")
        .lastName("Doe")
        .grades(Arrays.asList(59, 59, 58))
        .grade(10)
        .group("Group A")
        .age(20)
        .height(5.9)
        .build();
        System.out.println(student);
    }
}