package io.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DatePeriodUtilTest {
    private static final DatePeriod BASE_PERIOD = new DatePeriod(LocalDate.of(2023, 01, 14), LocalDate.of(2023, 02, 05));

    private static final DatePeriod START_OVERLAP = new DatePeriod(LocalDate.of(2023, 01, 12), LocalDate.of(2023, 01, 16));
    private static final DatePeriod WHOLLY_IN_PERIOD = new DatePeriod(LocalDate.of(2023, 01, 15), LocalDate.of(2023, 02, 04));
    private static final DatePeriod END_OVERLAP = new DatePeriod(LocalDate.of(2023, 02, 04), LocalDate.of(2023, 02, 06));
    
    private static final DatePeriod WHOLLY_COVERS_PERIOD = new DatePeriod(BASE_PERIOD.getStart().minus(Period.ofDays(1)),
    		BASE_PERIOD.getEnd().plus(Period.ofDays(1)));

    private static final DatePeriod SINGLE_DATE_PERIOD_START = new DatePeriod(LocalDate.of(2023, 01, 14), LocalDate.of(2023, 01, 14));
    private static final DatePeriod SINGLE_DATE_PERIOD_END = new DatePeriod(LocalDate.of(2023, 02, 05), LocalDate.of(2023, 02, 05));

    private static final DatePeriod OVERLAPPING_START_DAY = new DatePeriod(LocalDate.of(2023, 01, 13), LocalDate.of(2023, 01, 14));
    private static final DatePeriod OVERLAPPING_END_DAY = new DatePeriod(LocalDate.of(2023, 02, 05), LocalDate.of(2023, 02, 06));

    private static final DatePeriod PERIOD_BEFORE = new DatePeriod(LocalDate.of(2023, 01, 01), LocalDate.of(2023, 01, 13));
    private static final DatePeriod PERIOD_AFTER = new DatePeriod(LocalDate.of(2023, 02, 06), LocalDate.of(2023, 02, 12));

    @Test
    void testForOverlappingPeriodsWithStartOverlap() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, START_OVERLAP)).isTrue();
    }

    @Test
    void testForOverlappingPeriodsWithEndOverlap() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, END_OVERLAP)).isTrue();
    }

    @Test
    void testForOverlappingPeriodsWithWholePeriodOverlap() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, WHOLLY_IN_PERIOD)).isTrue();
    }

    @Test
    void testForOverlappingPeriodsWithWholeCover() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, WHOLLY_COVERS_PERIOD)).isTrue();
    }


    @Test
    void testForOverlappingPeriodsWithSingleDatePeriodWithStartOverlap() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, SINGLE_DATE_PERIOD_START)).isTrue();
    }

    @Test
    void testForOverlappingPeriodsWithSingleDatePeriodWithEndOverlap() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, SINGLE_DATE_PERIOD_END)).isTrue();
    }

    @Test
    void testForOverlappingPeriodsWithStartDateSpecificallyOverlapping() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, OVERLAPPING_START_DAY)).isTrue();
    }

    @Test
    void testForOverlappingPeriodsWithEndDateSpecificallyOverlapping() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, OVERLAPPING_END_DAY)).isTrue();
    }

    @Test
    void testForNonOverlappingPeriodBefore() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, PERIOD_BEFORE)).isFalse();
    }

    @Test
    void testForNonOverlappingPeriodAfter() {
        assertThat(DatePeriodUtil.areOverlapping(BASE_PERIOD, PERIOD_AFTER)).isFalse();
    }

}
