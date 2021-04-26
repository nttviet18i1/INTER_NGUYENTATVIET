package models;

public class Room extends Services {
    private String freeServices;

    public Room(int id, String name, double areaUsed, int rentCost, int maxPeople, String typeRent, String freeServices) {
        super(id, name, areaUsed, rentCost, maxPeople, typeRent);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeServices='" + freeServices + '\'' +
                '}';
    }
    public String getInfoRoom(){
        return (this.getId()+","+this.getName()+","+this.getAreaUsed()+","+this.getRentCost()+","+this.getMaxPeople()+","+this.getTypeRent()+ ","+this.getFreeServices());

    }

    @Override
    public void showInfo() {

    }
}
