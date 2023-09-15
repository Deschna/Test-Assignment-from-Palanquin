package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomDateMonthComparatorTest {
    private final Comparator<LocalDate> comparator;
    private static final String SORT_STRING = "r";

    public CustomDateMonthComparatorTest() {
        comparator = new CustomDateMonthComparator(SORT_STRING);
    }

    @Test
    public void testCompareMonthWithSortString_Ok() {
        LocalDate date1 = LocalDate.of(2023, Month.JANUARY, 1);
        LocalDate date2 = LocalDate.of(2023, Month.MARCH, 1);

        int result = comparator.compare(date1, date2);

        assertTrue(result < 0);
    }

    @Test
    public void testCompareMonthWithNoSortString_Ok() {
        LocalDate date1 = LocalDate.of(2023, Month.AUGUST, 1);
        LocalDate date2 = LocalDate.of(2023, Month.JULY, 1);

        int result = comparator.compare(date1, date2);

        assertTrue(result < 0);
    }

    @Test
    public void testCompareMonthWithAndWithoutStringToSort_Ok() {
        LocalDate date1 = LocalDate.of(2022, Month.JULY, 1);
        LocalDate date2 = LocalDate.of(2024, Month.SEPTEMBER, 1);

        int result = comparator.compare(date1, date2);

        assertTrue(result > 0);
    }

    @Test
    public void testCompareSameDate_Ok(){
        LocalDate date1 = LocalDate.of(2022, Month.JULY, 1);
        LocalDate date2 = LocalDate.of(2022, Month.JULY, 1);

        int result = comparator.compare(date1, date2);

        assertEquals(0, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareNullDate_NotOk() {
        LocalDate date1 = LocalDate.of(2023, Month.JANUARY, 1);

        comparator.compare(date1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCompareBothNullDates_NotOk() {
        comparator.compare(null, null);
    }
}
