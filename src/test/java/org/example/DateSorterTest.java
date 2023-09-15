package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.fail;

public class DateSorterTest {
    private final DateSorter dateSorter;
    private final List<LocalDate> listToSort;
    private final List<LocalDate> sortedList;
    private static final String SORT_STRING = "r";

    public DateSorterTest() {
        Comparator<LocalDate> comparator = new CustomDateMonthComparator(SORT_STRING);
        dateSorter = new DateSorter(comparator);

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
