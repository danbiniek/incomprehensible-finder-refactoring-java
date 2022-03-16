package algorithm;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AgeDifferenceTypeTest {

    @Test
    public void aCloserAgeDifference_isReturned_whenClosestTypeIsSelected() {
        var small1 = new Person("small1", LocalDate.of(1994, 1, 1));
        var small2 = new Person("small2", LocalDate.of(1995, 1, 1));
        var smaller = new PeopleYearDifference(small1, small2);

        var further1 = new Person("further1", LocalDate.of(1944, 1, 1));
        var further2 = new Person("further2", LocalDate.of(1995, 1, 1));
        var further = new PeopleYearDifference(further1, further2);

        var result = AgeDifferenceType.CLOSEST.comparePeople(smaller, further);

        assertEquals(smaller, result);
    }

    @Test
    public void aFurtherAgeDifference_isReturned_whenFurtherTypeIsSelected() {
        var small1 = new Person("small1", LocalDate.of(1994, 1, 1));
        var small2 = new Person("small2", LocalDate.of(1995, 1, 1));
        var smaller = new PeopleYearDifference(small1, small2);

        var further1 = new Person("further1", LocalDate.of(1944, 1, 1));
        var further2 = new Person("further2", LocalDate.of(1995, 1, 1));
        var further = new PeopleYearDifference(further1, further2);

        var result = AgeDifferenceType.FURTHEST.comparePeople(smaller, further);

        assertEquals(further, result);
    }

}