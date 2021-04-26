package service;

import commons.ReadFileCSV;
import commons.WriteFileCSV;
import models.House;
import models.Room;
import models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomService {
    public static final String PATH_ROOM="D:\\A0920I1-NGUYENTATVIET\\castudy02\\src\\Data\\room.csv";
    public static Scanner scanner= new Scanner(System.in);
    private static List<Room> roomsList = new ArrayList<>();
    public static  void addNewRoom(){

        System.out.println("Enter the ID Service ");
        String id = scanner.nextLine();
        System.out.println("Enter the Name Service ");
        String name = scanner.nextLine();
        System.out.println("Enter the Are Used Service");
        double areaUsed=Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the rentCost Service ");
        int rentCost= Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the Max people Service");
        int maxPeople= Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the type Rent Service");
        String typeRent= scanner.nextLine();
        System.out.println("Enter the Free Service");
         String freeServices = scanner.nextLine();


     Room newRoom= new Room(Integer.parseInt(id),name,areaUsed,rentCost,maxPeople,typeRent,freeServices);

        roomsList.add(newRoom);
        WriteFileCSV writeFileCSV = new WriteFileCSV();
        writeFileCSV.write(PATH_ROOM,newRoom.getInfoRoom(),true);
    }
    public  static  void showRoom() {

        List<String>stringList = ReadFileCSV.readCSV(PATH_ROOM);
        roomsList = new ArrayList<>();
        String[] temp = null;
        for (String str: stringList) {
            temp = str.split(",");
           Room room = new Room(Integer.parseInt(temp[0]),temp[1],Double.parseDouble(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6]);
            roomsList.add(room);
        }
        for(Room room:roomsList){
            System.out.println(room.getInfoRoom());

        }

    }
}
