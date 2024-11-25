package apps.task2;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@ToString @Getter @SuperBuilder
public class Client {
    private static int counter = 0;
    private int id = counter++;
    private String name;
    private LocalDate dob;
    private String gender;
    private String email;
}
