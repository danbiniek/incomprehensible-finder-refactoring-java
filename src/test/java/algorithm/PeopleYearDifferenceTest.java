package algorithm;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PeopleYearDifferenceTest {

    @Test
    public void anEmptyResult_shouldBeReturned_whenEmptyStaticCalled() {
        var empty = PeopleYearDifference.EMPTY;

        assertNull(empty.getYoung());
        assertNull(empty.getOld());
    }

    @Test
    public void aCorrectPeople_shouldBeAdded_whenNewObjectIsCreated() {
        Person young = new Person("test1", LocalDate.of(1999, 1, 1));
        Person old = new Person("test2", LocalDate.of(1999, 1, 1));
        var result = new PeopleYearDifference(young, old);

        assertEquals("test1", result.getYoung().name());
        assertEquals("test2", result.getOld().name());
    }

    @Test
    public void aCorrectAgeDifference_shouldBeCalculated_whenNewObjectIsCreated() {
        Person young = new Person("test1", LocalDate.of(1999, 1, 1));
        Person old = new Person("test2", LocalDate.of(1989, 1, 1));
        var result = new PeopleYearDifference(young, old);

        assertEquals(10, result.getYearDifference());
    }
}