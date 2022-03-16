package algorithm;

import java.util.Comparator;

public enum AgeDifferenceType {
    CLOSEST(Comparator.comparingLong(PeopleYearDifference::getYearDifference)),
    FURTHEST(Comparator.comparingLong(PeopleYearDifference::getYearDifference).reversed());

    AgeDifferenceType(Comparator<PeopleYearDifference> ageDistanceComparator) {
        this.ageDistanceComparator = ageDistanceComparator;
    }

    private Comparator<PeopleYearDifference> ageDistanceComparator;

    public Comparator<PeopleYearDifference> getAgeDistanceComparator() {
        return ageDistanceComparator;
    }
}
