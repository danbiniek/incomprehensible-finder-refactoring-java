package algorithm;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public enum AgeDifferenceType {
    CLOSEST((answer, result) -> getPeopleYearDifference(answer, result, (a, r) -> a.getYearDifference() < r.getYearDifference())),
    FURTHEST((answer, result) -> getPeopleYearDifference(answer, result, (a, r) -> a.getYearDifference() > r.getYearDifference()));

    private BiFunction<PeopleYearDifference, PeopleYearDifference, PeopleYearDifference> compareAgeDistance;

    AgeDifferenceType(BiFunction<PeopleYearDifference, PeopleYearDifference, PeopleYearDifference> compareAgeDistance) {
        this.compareAgeDistance = compareAgeDistance;
    }

    public PeopleYearDifference comparePeople(PeopleYearDifference answer, PeopleYearDifference result) {
        return this.compareAgeDistance.apply(answer, result);
    }

    private static PeopleYearDifference getPeopleYearDifference(PeopleYearDifference answer, PeopleYearDifference result,
                                                                BiPredicate<PeopleYearDifference, PeopleYearDifference> agePredicate) {
        if (agePredicate.test(result, answer)) {
            return result;
        }
        return answer;
    }

}
