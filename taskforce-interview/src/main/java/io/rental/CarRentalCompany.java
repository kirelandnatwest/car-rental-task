package io.rental;

import java.util.ArrayList;
import java.util.List;

public class CarRentalCompany {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> matchingCars(Criteria criteria) {
        return cars;
    }

    public void rentCar(Renter renter, Car car) {}

    public void returnCar(Renter renter, Car car) {}
}
