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
        MagicGenerator mg = new MagicGenerator();
        this.setColor(mg.getRandomColor());
        this.setLicensePlate(mg.getRandomLicencePlate());
        this.setManufacturer(mg.getRandomManufacturer());
        this.setModel(mg.getRandomModel(this.getManufacturer()));
        this.setOwner(mg.getRandomName());
    }

    @Override
    public String toString() {
        return  "Licence-Plate: " + this.getLicensePlate() +
                "\nOwner: " + this.getOwner() +
                "\nManufacturer: " + this.getManufacturer() +
                "\nModel: " + this.getModel() +
                "\nColor: " + this.getColor() + "\n\n";

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
