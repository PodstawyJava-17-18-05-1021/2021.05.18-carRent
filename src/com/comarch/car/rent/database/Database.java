package com.comarch.car.rent.database;

import com.comarch.car.rent.model.Car;

public class Database {
    private Car[] cars = new Car[3];

    public Database() {
        this.cars[0] = new Car("BMW", "5", "KR111");
        this.cars[1] = new Car("Toyota", "Corolla", "KR222");
        this.cars[2] = new Car("Mazda", "6", "KR333");
    }

    public Car[] getCars() {
        return this.cars;
    }

    public Car getCarByPlate(String plate) {
        for(Car car : this.cars) {
            if(car.getPlate().equals(plate)) {
                return car;
            }
        }

        return null;
    }
}