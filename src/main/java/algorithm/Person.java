package algorithm;

import java.time.LocalDate;

public class Person {
    public String name;
    public LocalDate birthDate;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

