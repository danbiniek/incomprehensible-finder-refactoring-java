package algorithm;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public record Finder(List<Person> people) {

    public PeopleYearDifference find(AgeDifferenceType diffType) {
        Set<PeopleYearDifference> peopleYearDifferences = matchEveryone(diffType);
        return getBestMatch(peopleYearDifferences);
    }

    private PeopleYearDifference getBestMatch(Set<PeopleYearDifference> peopleYearDifferences) {
        if (peopleYearDifferences.isEmpty()) {
            return PeopleYearDifference.EMPTY;
        }
        return peopleYearDifferences.iterator().next();
    }

    private Set<PeopleYearDifference> matchEveryone(AgeDifferenceType diffType) {
        var peopleYearDifferences = new TreeSet<>(diffType.getAgeDistanceComparator());
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                if (people.get(i).birthDate().isAfter(people.get(j).birthDate())) {
                    peopleYearDifferences.add(new PeopleYearDifference(people.get(i), people.get(j)));
                } else {
                    peopleYearDifferences.add(new PeopleYearDifference(people.get(j), people.get(i)));
                }
            }
        }
        return peopleYearDifferences;
    }
}