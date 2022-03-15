package algorithm;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FinderTest {

    Person sue = new Person();
    Person greg = new Person();
    Person sarah = new Person();
    Person mike = new Person();

    @Before
    public void setup() {
        sue.name = "Sue";
        sue.birthDate = LocalDate.of(1972, 1, 1);
        greg.name = "Greg";
        greg.birthDate = LocalDate.of(1970, 5, 1);
        sarah.name = "Sarah";
        sarah.birthDate = LocalDate.of(1940, 1, 1);
        mike.name = "Mike";
        mike.birthDate = LocalDate.of(1943, 1, 1);
    }

    @Test
    public void Returns_Empty_Results_When_Given_Empty_List() {
        List<Person> list = new ArrayList<>();
        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(Difference.CLOSEST);
        assertEquals(null, result.young);

        assertEquals(null, result.old);
    }

    @Test
    public void Returns_Empty_Results_When_Given_One_Person() {
        List<Person> list = new ArrayList<>();
        list.add(sue);

        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(Difference.CLOSEST);

        assertEquals(null, result.young);
        assertEquals(null, result.old);
    }

    @Test
    public void Returns_Closest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(greg);
        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(Difference.CLOSEST);

        assertEquals(sue, result.young);
        assertEquals(greg, result.old);
    }

    @Test
    public void Returns_Furthest_Two_For_Two_People() {
        List<Person> list = new ArrayList<>();
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(Difference.FURTHEST);

        assertEquals(greg, result.young);
        assertEquals(mike, result.old);
    }

    @Test
    public void Returns_Furthest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);
        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(Difference.FURTHEST);

        assertEquals(sue, result.young);
        assertEquals(sarah, result.old);
    }

    @Test
    public void Returns_Closest_Two_For_Four_People() {
        List<Person> list = new ArrayList<>();
        list.add(sue);
        list.add(sarah);
        list.add(mike);
        list.add(greg);

        Finder finder = new Finder(list);

        PeopleYearDifference result = finder.find(Difference.CLOSEST);

        assertEquals(sue, result.young);
        assertEquals(greg, result.old);
    }

}
