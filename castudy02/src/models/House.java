package models;

public class House extends Services {
private String standardRoom;
private String detailConvenient;
private int floor;

public House(String standardRoom, String detailConvenient, int floor) {
        this.standardRoom = standardRoom;
        this.detailConvenient = detailConvenient;
        this.floor = floor;
        }

public House(int id, String name, double areaUsed, int rentCost, int maxPeople, String typeRent, String standardRoom, String detailConvenient, int floor) {
        super(id, name, areaUsed, rentCost, maxPeople, typeRent);
        this.standardRoom = standardRoom;
        this.detailConvenient = detailConvenient;
        this.floor = floor;
        }

public String getStandardRoom() {
        return standardRoom;
        }

public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
        }

public String getDetailConvenient() {
        return detailConvenient;
        }

public void setDetailConvenient(String detailConvenient) {
        this.detailConvenient = detailConvenient;
        }

public int getFloor() {
        return floor;
        }

public void setFloor(int floor) {
        this.floor = floor;
        }

@Override
public String toString() {
        return "House{" +
        "standardRoom='" + standardRoom + '\'' +
        ", detailConvenient='" + detailConvenient + '\'' +
        ", floor=" + floor +
        '}';
        }
public String getInfoHouse(){
        return (this.getId()+","+this.getName()+","+this.getAreaUsed()+","+this.getRentCost()+","+this.getMaxPeople()+","+this.getTypeRent()+ ","+this.getStandardRoom()+","+this.getDetailConvenient()+","+getFloor());

        }

@Override
public void showInfo() {

        }
        }
