package designpattern.creational.builder;

/**
 * In Builder pattern,
 * We give responsibility of setting/handling required and optional fields and creating object of it to an inner builder class.
 *
 * To achieve builder pattern,
 * We should send all fields of Vehicle class in object of type static VehicleBuilder class which is nested/inner class.
 *
 * In VehicleBuilder class, the required attribute should be sent in a Contructor method and optional fields
 * should be set through setter method.
 * And object of Vehicle class should be created through a method build() in VehicleBuilder class.
 *
 * Here field engine and wheel are required fields and airbags is an optional field.
 * */
class Vehicle {
    //required parameter
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    // Passing VehicleBuilder object. Making Vehicle Contructor private so that it cannot be able to create object directly
    // We have to create Vehicle through a method build() available in VehicleBuilder which will call this Constructor.
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // This class is responsible for setting required and optional fields and creating Vehicle class object.
    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        // Returning this so that build method can be chained after calling setAirbags method.
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        // Vehicle object should always be created from this method.
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderPatternExample {

    public static void main(String[] args) {
        // Setting the fields and creating object through build method.
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}
