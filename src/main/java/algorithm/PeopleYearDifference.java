package algorithm;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class PeopleYearDifference {

    public static final PeopleYearDifference EMPTY = new PeopleYearDifference();

    private Person younger;
    private Person older;
    private long yearDifference;

    private PeopleYearDifference() {
    }

    public PeopleYearDifference(Person younger, Person older) {
        requireNonNull(younger);
        requireNonNull(older);
        this.younger = younger;
        this.older = older;
        this.yearDifference = Math.abs(younger.birthDate().getYear() - older.birthDate().getYear());
    }

    public long getYearDifference() {
        return yearDifference;
    }

    public Person getOlder() {
        return older;
    }

    public Person getYounger() {
        return younger;
    }

    @Override
    public String toString() {
        return "PeopleYearDifference{" +
                "young=" + younger +
                ", old=" + older +
                ", yearDifference=" + yearDifference +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleYearDifference that = (PeopleYearDifference) o;
        return Objects.equals(younger, that.younger) && Objects.equals(older, that.older);
    }

    @Override
    public int hashCode() {
        return Objects.hash(younger, older);
    }
}
