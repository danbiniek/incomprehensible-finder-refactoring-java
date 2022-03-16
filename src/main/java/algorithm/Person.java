package algorithm;

import java.time.LocalDate;
import java.util.Objects;

public record Person(String name, LocalDate birthDate) {

    public Person {
        Objects.requireNonNull(name);
        Objects.requireNonNull(birthDate);
    }
}

