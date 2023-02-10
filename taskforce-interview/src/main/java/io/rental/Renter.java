package io.rental;

import java.time.LocalDate;

public class Renter {
    private final String lastName;
    private final String firstName;
    private final String drivingLicenseNumber;
    private final LocalDate dateOfBirth;

    public Renter(String lastName, String firstName, String drivingLicenseNumber, LocalDate dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
