package algorithm;

import static java.util.Objects.requireNonNull;

public class PeopleYearDifference {

    public static final PeopleYearDifference EMPTY = new PeopleYearDifference();

    private Person young;
    private Person old;
    private long yearDifference;

    private PeopleYearDifference() {
    }

    public PeopleYearDifference(Person young, Person old) {
        requireNonNull(young);
        requireNonNull(old);
        this.young = young;
        this.old = old;
        this.yearDifference = young.birthDate().getYear() - old.birthDate().getYear();
    }

    public long getYearDifference() {
        return yearDifference;
    }

    public Person getOld() {
        return old;
    }

    public Person getYoung() {
        return young;
    }
}
