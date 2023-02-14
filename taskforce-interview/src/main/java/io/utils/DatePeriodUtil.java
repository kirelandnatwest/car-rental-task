package io.utils;

import java.time.LocalDate;

public class DatePeriodUtil {

    /**
     * Check two date periods to see if they are overlapping.
     * @param period1
     * @param period2
     * @return true if
     */
    public static boolean areOverlapping(DatePeriod period1, DatePeriod period2) {
        return ((period1.getStart().isBefore(period2.getStart()) || period1.getStart().isEqual(period2.getStart())) && (isInPeriod(period1.getEnd(), period2) || period1.getEnd().isAfter(period2.getEnd()))) ||
                ((isInPeriod(period1.getStart(), period2) || period1.getStart().isBefore(period2.getStart())) && (period1.getEnd().isAfter(period2.getEnd()) || period1.getEnd().isEqual(period2.getEnd())));
    }

    /**
     * Inclusive in period check, i.e. if date is equal to start or end of period then still classified as in period.
     * @param date
     * @param period
     * @return
     */
    public static boolean isInPeriod(LocalDate date, DatePeriod period) {
        return (date.isAfter(period.getStart()) && date.isBefore(period.getEnd()))
                || date.isEqual(period.getStart())
                || date.isEqual(period.getEnd());
    }
}
