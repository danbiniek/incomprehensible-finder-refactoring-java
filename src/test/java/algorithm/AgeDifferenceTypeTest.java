package algorithm;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class AgeDifferenceTypeTest {

    @Test
    public void aCloserAgeDifference_shouldReturnAscendingComparator_whenClosestTypeIsSelected() {
        var comparator = AgeDifferenceType.CLOSEST.getAgeDistanceComparator();
        Set<PeopleYearDifference> testPeoplesYearDiffs = new TreeSet<>(comparator);

        var small1 = new Person("small1", LocalDate.of(1994, 1, 1));
        var small2 = new Person("small2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(small1, small2));

        var further1 = new Person("further1", LocalDate.of(1944, 1, 1));
        var further2 = new Person("further2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(further1, further2));

        assertEquals(new PeopleYearDifference(small1, small2), testPeoplesYearDiffs.iterator().next());
    }

    @Test
    public void aFurtherAgeDifference_isReturned_whenFurtherTypeIsSelected() {
        var comparator = AgeDifferenceType.FURTHEST.getAgeDistanceComparator();
        Set<PeopleYearDifference> testPeoplesYearDiffs = new TreeSet<>(comparator);

        var small1 = new Person("small1", LocalDate.of(1994, 1, 1));
        var small2 = new Person("small2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(small1, small2));

        var further1 = new Person("further1", LocalDate.of(1944, 1, 1));
        var further2 = new Person("further2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(further1, further2));

        assertEquals(new PeopleYearDifference(further1, further2), testPeoplesYearDiffs.iterator().next());
    }

    @Test
    public void aCloserAgeDifference_shouldReturnAscendingComparator_whenClosestTypeIsSelectedAndListIsInOrdered() {
        var comparator = AgeDifferenceType.CLOSEST.getAgeDistanceComparator();
        Set<PeopleYearDifference> testPeoplesYearDiffs = new TreeSet<>(comparator);

        var further1 = new Person("further1", LocalDate.of(1944, 1, 1));
        var further2 = new Person("further2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(further1, further2));

        var small1 = new Person("small1", LocalDate.of(1994, 1, 1));
        var small2 = new Person("small2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(small1, small2));

        assertEquals(new PeopleYearDifference(small1, small2), testPeoplesYearDiffs.iterator().next());
    }

    @Test
    public void aFurtherAgeDifference_isReturned_whenFurtherTypeIsSelectedAndListIsInOrdered() {
        var comparator = AgeDifferenceType.FURTHEST.getAgeDistanceComparator();
        Set<PeopleYearDifference> testPeoplesYearDiffs = new TreeSet<>(comparator);

        var further1 = new Person("further1", LocalDate.of(1944, 1, 1));
        var further2 = new Person("further2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(further1, further2));

        var small1 = new Person("small1", LocalDate.of(1994, 1, 1));
        var small2 = new Person("small2", LocalDate.of(1995, 1, 1));
        testPeoplesYearDiffs.add(new PeopleYearDifference(small1, small2));

        assertEquals(new PeopleYearDifference(further1, further2), testPeoplesYearDiffs.iterator().next());
    }

}