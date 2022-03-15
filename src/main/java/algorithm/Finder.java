package algorithm;

import java.util.ArrayList;
import java.util.List;

public record Finder(List<Person> people) {

    public PeopleYearDifference find(Difference distance) {
        List<PeopleYearDifference> peopleYearDifferences = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                var peopleYearDifference = new PeopleYearDifference();
                if (people.get(i).birthDate.isAfter(people.get(j).birthDate)) {
                    peopleYearDifference.young = people.get(i);
                    peopleYearDifference.old = people.get(j);
                } else {
                    peopleYearDifference.young = people.get(j);
                    peopleYearDifference.old = people.get(i);
                }
                peopleYearDifference.yearDifference = peopleYearDifference.young.birthDate.getYear() - peopleYearDifference.old.birthDate.getYear();
                peopleYearDifferences.add(peopleYearDifference);
            }
        }

        if (peopleYearDifferences.size() < 1) {
            return new PeopleYearDifference();
        }

        PeopleYearDifference answer = peopleYearDifferences.get(0);
        for (PeopleYearDifference result : peopleYearDifferences) {
            switch (distance) {
                case CLOSEST:
                    if (result.yearDifference < answer.yearDifference) {
                        answer = result;
                    }
                    break;

                case FURTHEST:
                    if (result.yearDifference > answer.yearDifference) {
                        answer = result;
                    }
                    break;
            }
        }

        return answer;
    }
}
