package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;

class CustomDateMonthComparator implements Comparator<LocalDate> {
    private final String sortString;

    public CustomDateMonthComparator(String sortString) {
        this.sortString = sortString;
    }

    @Override
    public int compare(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate == null || secondDate == null) {
            throw new IllegalArgumentException("One of the dates is null!");
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
