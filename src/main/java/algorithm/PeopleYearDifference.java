package algorithm;

import static java.util.Objects.requireNonNull;

public class PeopleYearDifference {

    public static final PeopleYearDifference EMPTY = new PeopleYearDifference();

    public Person young;
    public Person old;
    public long yearDifference;

    private PeopleYearDifference() {
    }

    public PeopleYearDifference(Person young, Person old) {
        requireNonNull(young);
        requireNonNull(old);
        this.young = young;
        this.old = old;
        this.yearDifference = young.birthDate().getYear() - old.birthDate().getYear();
    }
}
