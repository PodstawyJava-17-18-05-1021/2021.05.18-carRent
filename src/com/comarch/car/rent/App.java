package com.comarch.car.rent;

import com.comarch.car.rent.database.Database;
import com.comarch.car.rent.model.Car;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Database database = new Database();
        while (true) {
            System.out.println("1. Wyświetl pojazdy");
            System.out.println("2. Wypożycz pojazd");
            System.out.println("3. Zwróć pojazd");
            System.out.println("4. Wyjdź");

            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();

            switch (choose) {
                case "1":
                    Car[] cars = database.getCars();
                    for (Car car : cars) {
                        System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getPlate() + " " + car.isRent());
                    }
                    break;
                case "2":
                    System.out.println("Wpisz numer rejestracyjny:");
                    String plate = scanner.nextLine();

                    Car car = database.getCarByPlate(plate);

                    if(car != null && !car.isRent()) {
                        car.setRent(true);
                        System.out.println("Wypożyczono !!");
                    } else {
                        System.out.println("Nie znaleziono auta lub jest wypożyczone !!");
                    }
                    break;
                case "3":
                    System.out.println("Wpisz numer rejestracyjny:");
                    String plate2 = scanner.nextLine();

                    Car car2 = database.getCarByPlate(plate2);

                    if(car2 != null && car2.isRent()) {
                        car2.setRent(false);
                        System.out.println("Zwrócono pojazd !!");
                    } else {
                        System.out.println("Nie znaleziono auta lub nie jest wypożyczone !!");
                    }
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór");
                    break;
            }
        }
    }
}
