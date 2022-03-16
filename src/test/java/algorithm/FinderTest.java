package algorithm;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FinderTest {

    private Person sue;
    private Person greg;
    private Person sarah;
    private Person mike;

    @Before
    public void setup() {
        sue = new Person("Sue", LocalDate.of(1972, 1, 1));
        greg = new Person("Greg", LocalDate.of(1970, 5, 1));
        sarah = new Person("Sarah", LocalDate.of(1940, 1, 1));
        mike = new Person("Mike", LocalDate.of(1943, 1, 1));
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();
        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(AgeDifferenceType.CLOSEST);
        assertEquals(null, result.getYounger());
        assertEquals(null, result.getOlder());
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<>();
        list.add(sue);

        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(AgeDifferenceType.CLOSEST);

        assertEquals(null, result.getYounger());
        assertEquals(null, result.getOlder());
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(AgeDifferenceType.CLOSEST);

        assertEquals(sue, result.getYounger());
        assertEquals(greg, result.getOlder());
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(AgeDifferenceType.FURTHEST);

        assertEquals(greg, result.getYounger());
        assertEquals(mike, result.getOlder());
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(AgeDifferenceType.FURTHEST);

        assertEquals(sue, result.getYounger());
        assertEquals(sarah, result.getOlder());
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(AgeDifferenceType.CLOSEST);

        assertEquals(sue, result.getYounger());
        assertEquals(greg, result.getOlder());
    }

}
