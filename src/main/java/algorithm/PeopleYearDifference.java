package algorithm;

public class PeopleYearDifference {
    public Person young;
    public Person old;
    public long yearDifference;

    public PeopleYearDifference() {
    }

    public PeopleYearDifference(Person young, Person old) {
        this.young = young;
        this.old = old;
        this.yearDifference = young.birthDate.getYear() - old.birthDate.getYear();
    }
}
