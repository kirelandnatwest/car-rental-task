package io.utils;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DatePeriodTest {

    @Test
    void testValidDatePeriodConstruction() {
        new DatePeriod(LocalDate.of(2023, 01, 15), LocalDate.of(2023, 01, 16));
    }

    @Test
    void testValidDatePeriodConstructionStartEndSame() {
        new DatePeriod(LocalDate.of(2023, 01, 15), LocalDate.of(2023, 01, 15));
    }

    @Test
    void testInvalidDatePeriodConstruction() {
        assertThrows(AssertionError.class, () -> new DatePeriod(LocalDate.of(2023, 01, 16), LocalDate.of(2023, 01, 15)));
    }
}