package algorithm;

import java.util.ArrayList;
import java.util.List;

public record Finder(List<Person> people) {

    public PeopleYearDifference find(Difference distance) {
        List<PeopleYearDifference> tr = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                PeopleYearDifference r = new PeopleYearDifference();
                if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
                    r.young = people.get(i);
                    r.old = people.get(j);
                } else {
                    r.young = people.get(j);
                    r.old = people.get(i);
                }
                r.yearDifference = r.old.birthDate.getTime() - r.young.birthDate.getTime();
                tr.add(r);
            }
        }

        if (tr.size() < 1) {
            return new PeopleYearDifference();
        }

        PeopleYearDifference answer = tr.get(0);
        for (PeopleYearDifference result : tr) {
            switch (distance) {
                case THE_SMALLEST:
                    if (result.yearDifference < answer.yearDifference) {
                        answer = result;
                    }
                    break;

                case THE_BIGGEST:
                    if (result.yearDifference > answer.yearDifference) {
                        answer = result;
                    }
                    break;
            }
        }

        return answer;
    }
}
