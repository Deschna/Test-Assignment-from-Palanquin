package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateSorterTest {
    private static DateSorter dateSorter;
    private static List<LocalDate> exampleListToSort;
    private static List<LocalDate> exampleSortedList;
    private static List<LocalDate> listToSort;
    private static List<LocalDate> sortedList;
    private static final String SORT_STRING = "r";

    @BeforeAll
    public static void setUp() {
        dateSorter = new DateSorter(SORT_STRING);

        exampleListToSort = new ArrayList<>();
        exampleListToSort.add(LocalDate.of(2005, 7, 1));
        exampleListToSort.add(LocalDate.of(2005, 1, 2));
        exampleListToSort.add(LocalDate.of(2005, 1, 1));
        exampleListToSort.add(LocalDate.of(2005, 5, 3));

        exampleSortedList = new ArrayList<>();
        exampleSortedList.add(LocalDate.of(2005, 1, 1));
        exampleSortedList.add(LocalDate.of(2005, 1, 2));
        exampleSortedList.add(LocalDate.of(2005, 7, 1));
        exampleSortedList.add(LocalDate.of(2005, 5, 3));

        listToSort = new ArrayList<>();
        listToSort.add(LocalDate.of(2023, Month.JANUARY, 25));
        listToSort.add(LocalDate.of(2024, Month.JANUARY, 25));
        listToSort.add(LocalDate.of(2023, Month.APRIL, 10));
        listToSort.add(LocalDate.of(2023, Month.SEPTEMBER, 5));
        listToSort.add(LocalDate.of(2023, Month.DECEMBER, 5));
        listToSort.add(LocalDate.of(2023, Month.MAY, 10));
        listToSort.add(LocalDate.of(2023, Month.AUGUST, 20));
        listToSort.add(LocalDate.of(2024, Month.MAY, 10));

        sortedList = new ArrayList<>();
        sortedList.add(LocalDate.of(2023, Month.JANUARY, 25));
        sortedList.add(LocalDate.of(2023, Month.APRIL, 10));
        sortedList.add(LocalDate.of(2023, Month.SEPTEMBER, 5));
        sortedList.add(LocalDate.of(2023, Month.DECEMBER, 5));
        sortedList.add(LocalDate.of(2024, Month.JANUARY, 25));
        sortedList.add(LocalDate.of(2024, Month.MAY, 10));
        sortedList.add(LocalDate.of(2023, Month.AUGUST, 20));
        sortedList.add(LocalDate.of(2023, Month.MAY, 10));
    }

    @Test
    public void testSortDates_ExampleData_Ok() {
        List<LocalDate> actual = (List<LocalDate>) dateSorter.sortDates(exampleListToSort);

        assertEquals(exampleSortedList, actual);
    }

    @Test
    public void testSortDates_ComplexTest_Ok() {
        List<LocalDate> actual = (List<LocalDate>) dateSorter.sortDates(listToSort);

        assertEquals(sortedList, actual);
    }

    @Test
    public void testSortDates_NullInput_NotOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            dateSorter.sortDates(null);
        });
    }

    @Test
    public void testSortDates_SomeDatesAreNull_NotOk() {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.of(2005, 7, 1));
        dates.add(null);
        assertThrows(IllegalArgumentException.class, () -> {
            dateSorter.sortDates(dates);
        });
    }
}
