package model;

/**
 * @author Simon Sperr
 * @version 2020.3, 14.01.2021
 **/
public class Vehicle {

    private String color;
    private String owner;
    private String manufacturer;
    private String model;

    public Vehicle() {

    }

    @Override
    public String toString() {
        return "Manufacturer: " + this.getManufacturer() +
                "\nModel: " + this.getModel() +
                "\nColor: " + this.getColor() +
                "\nLicence-Plate: " + this.getLicensePlate() +
                "\nOwner: " + this.getOwner() + "\n\n";

    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    private String licensePlate;

    public String getColor() {
        return color;
    }

    public String getOwner() {
        return owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
