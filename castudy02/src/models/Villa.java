package models;

public class Villa extends Services {
    private String standardRoom;
    private String detailConvenient;
    private Double arePool;
    private int floor;
    public final String COMAN = ",";

    public Villa(String standardRoom, String detailConvenient, Double arePool, int floor, int i, String s, String s1, double v, int parseInt) {
        this.standardRoom = standardRoom;
        this.detailConvenient = detailConvenient;
        this.arePool = arePool;
        this.floor = floor;
    }


    public Villa(int id, String name, double areaUsed, int rentCost, int maxPeople, String typeRent, String standardRoom, String detailConvenient, Double arePool, int floor) {
        super(id, name, areaUsed, rentCost, maxPeople, typeRent);
        this.standardRoom = standardRoom;
        this.detailConvenient = detailConvenient;
        this.arePool = arePool;
        this.floor = floor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDetailConvenientf() {
        return detailConvenient;
    }

    public void setDetailConvenient(String detailConvenient) {
        this.detailConvenient = detailConvenient;
    }

    public Double getArePool() {
        return arePool;
    }

    public void setArePool(Double arePool) {
        this.arePool = arePool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public void showInfo() {
        System.out.println("standardRoom:" + this.standardRoom + "floor:" + this.floor);

    }

    @Override
    public String toString() {
        return this.getStandardRoom() + COMAN + this.getDetailConvenientf() + COMAN +this.getArePool() ;
    }
    public String getInfo(){
        return (this.getId()+","+this.getName()+","+this.getAreaUsed()+","+this.getRentCost()+","+this.getMaxPeople()+","+this.getTypeRent()+","+this.standardRoom+","+this.detailConvenient+","+this.arePool+","+this.floor);

    }
}