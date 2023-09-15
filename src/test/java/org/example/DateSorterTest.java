package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

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
    public void DateSortedExampleTest() {
        List<LocalDate> actual = (List<LocalDate>) dateSorter.sortDates(exampleListToSort);

        if (actual.size() != exampleSortedList.size()) {
            fail("Size of actual list is different from the expected list!");
        }

        for (int i = 0; i < exampleSortedList.size(); i++) {
            if (!actual.get(i).equals(exampleSortedList.get(i))) {
                fail("Mismatch at index " + i + ": Expected " + sortedList.get(i) + ", but got " + actual.get(i));
            }
        }
    }

    @Test
    public void DateSorterComplexTest() {
        List<LocalDate> actual = (List<LocalDate>) dateSorter.sortDates(listToSort);

        if (actual.size() != sortedList.size()) {
            fail("Size of actual list is different from the expected list!");
        }

        for (int i = 0; i < sortedList.size(); i++) {
            if (!actual.get(i).equals(sortedList.get(i))) {
                fail("Mismatch at index " + i + ": Expected " + sortedList.get(i) + ", but got " + actual.get(i));
            }
        }
    }
}
