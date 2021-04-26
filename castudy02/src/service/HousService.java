package service;

import commons.ReadFileCSV;
import commons.WriteFileCSV;
import models.House;
import models.Villa;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HousService {
    public static final String PATH_house="D:\\A0920I1-NGUYENTATVIET\\castudy02\\src\\Data\\house.csv";
    public static Scanner scanner= new Scanner(System.in);
    private static List<House> housesList = new ArrayList<>();
    public static  void addNewHouse(){
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
        System.out.println("Enter the type rent Service");
        String typeRent= scanner.nextLine();
        System.out.println("Enter the standard House");
        String standardRoom = scanner.nextLine();
        System.out.println("Enter the detailConvenient");
        String detailConvenient=scanner.nextLine();
        System.out.println("Enter the number of floor");
        int  floor=Integer.parseInt(scanner.nextLine()) ;

      House newHouse= new House(Integer.parseInt(id),name,areaUsed,rentCost,maxPeople,typeRent,standardRoom,detailConvenient,floor);

        housesList.add(newHouse);
        WriteFileCSV writeFileCSV = new WriteFileCSV();
        writeFileCSV.write(PATH_house,newHouse.getInfoHouse(),true);
    }
    public  static  void showHouse() {

        List<String>stringList = ReadFileCSV.readCSV(PATH_house);
       housesList = new ArrayList<>();
        String[] temp = null;
        for (String str: stringList) {
            temp = str.split(",");
            House house = new House(Integer.parseInt(temp[0]),temp[1],Double.parseDouble(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6],temp[7],Integer.parseInt(temp[8]));
            housesList.add(house);
        }
        for(House house:housesList){
            System.out.println(house.getInfoHouse());

        }

    }
}
