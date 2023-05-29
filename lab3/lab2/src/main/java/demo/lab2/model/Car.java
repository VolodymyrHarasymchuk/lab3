package demo.lab2.model;

public class Car {
    enum BodyType {
        Coupe, Sedan, SUV
    }
    private int id;
    private String name;
    private BodyType bodyType;
    private int power;
    private int price;

    public Car(int id, String name, BodyType bodyType, int power, int price) {
        this.id = id;
        this.name = name;
        this.bodyType = bodyType;
        this.power = power;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBodyType() {
        return bodyType.toString();
    }

    public int getPower() {
        return power;
    }

    public int getPrice() {
        return price;
    }
}
