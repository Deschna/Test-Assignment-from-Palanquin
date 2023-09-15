package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    private final String sortString;

    public DateSorter(String sortString) {
        this.sortString = sortString;
    }

    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> dates = new ArrayList<>(unsortedDates);
        int datesSize = dates.size();

        LocalDate temp;
        for (int i = 0; i < datesSize; i++) {
            for (int j = 1; j < datesSize - i; j++) {
                if (compareDate(dates.get(j - 1), dates.get(j)) > 0) {
                    temp = dates.get(j - 1);
                    dates.set(j - 1, dates.get(j));
                    dates.set(j, temp);
                }
            }
        }
        return dates;
    }

    private int compareDate(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate == null || secondDate == null) {
            throw new IllegalArgumentException("One of the dates is a null!");
        }

        boolean isFirstMonthContainsString = isMonthContainsStringToSort(firstDate.getMonth());
        boolean isSecondMonthContainsString = isMonthContainsStringToSort(secondDate.getMonth());

        if (isFirstMonthContainsString && isSecondMonthContainsString) {
            return firstDate.compareTo(secondDate);
        } else if (!isFirstMonthContainsString && !isSecondMonthContainsString) {
            return firstDate.compareTo(secondDate) * -1;
        } else {
            return isFirstMonthContainsString ? -1 : 1;
        }
    }

    private boolean isMonthContainsStringToSort(Month month) {
        return month.toString().contains(sortString.toUpperCase());
    }
}
