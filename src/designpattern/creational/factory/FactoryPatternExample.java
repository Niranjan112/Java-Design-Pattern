package designpattern.creational.factory;

/**
 * Super class/Base class
 * */
abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "Wheel: " + this.getWheel();
    }
}

/**
 * Child class
 * Car extending Vehicle
 * */
class Car extends Vehicle {
    int wheel;

    Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

/**
 * Child class
 * Bike extending Vehicle
 * */
class Bike extends Vehicle {
    int wheel;

    Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

/**
 * All child class object creation should be handled by a Factory/Central class.
 * This Factory class is responsible for object creation of all Vehicle's child classes.
 * Here we have to send the type of child class we want to create and with its data.
 * */
class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if(type == "car") {
            return new Car(wheel);
        } else if(type == "bike") {
            return new Bike(wheel);
        }

        return null;
    }
}

/**
 * Here we are sending the type of object and getting its instance from factory class.
 * */
public class FactoryPatternExample {

    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getInstance("car", 4);
        System.out.println(car);

        Vehicle bike = VehicleFactory.getInstance("bike", 2);
        System.out.println(bike);
    }

}
