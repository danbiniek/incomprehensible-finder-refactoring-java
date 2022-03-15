package algorithm;

import java.util.ArrayList;
import java.util.List;

public record Finder(List<Person> people) {

    public PeopleYearDifference find(Difference distance) {
        List<PeopleYearDifference> peopleYearDifferences = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                if (people.get(i).birthDate.isAfter(people.get(j).birthDate)) {
                    peopleYearDifferences.add(new PeopleYearDifference(people.get(i), people.get(j)));
                } else {
                    peopleYearDifferences.add(new PeopleYearDifference(people.get(j), people.get(i)));
                }
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