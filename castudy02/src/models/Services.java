package models;

public abstract class  Services {
    private int id;
    private String name;
    private double areaUsed;
    private int rentCost;
    private int maxPeople;
    private String typeRent;
    public abstract void showInfo();

    public Services() {
    }

    public Services(int id, String name, double areaUsed, int rentCost, int maxPeople, String typeRent) {
        this.id = id;
        this.name = name;
        this.areaUsed = areaUsed;
        this.rentCost = rentCost;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }
}
