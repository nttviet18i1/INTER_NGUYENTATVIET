package service;

import commons.ReadFileCSV;
import commons.Regex;
import commons.WriteFileCSV;
import models.Villa;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VillaService  {
    public static final String PATH_villa="D:\\A0920I1-NGUYENTATVIET\\castudy02\\src\\Data\\villas.csv";
    public static Scanner scanner= new Scanner(System.in);
    private static List<Villa> villaList = new ArrayList<>();

    public static  void addNewVilla(){
        /*String id;
        do {
            System.out.println("Enter the ID Service ");
            id = scanner.nextLine();
        }
        while(!(Regex.validateId(id)));
        String name;
        do {
            System.out.println("Enter the Name Service ");
           name = scanner.nextLine();
        }
        while(!(Regex.validateName(name)));*/
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
        String typeRent= scanner.nextLine();
        System.out.println("Enter the standard room");
        String standardRoom = scanner.nextLine();
        System.out.println("Enter the detailConvenient");
        String detailConvenient=scanner.nextLine();
        System.out.println("Enter the pool are");
        double arePool= Double.parseDouble(scanner.nextLine());;
        System.out.println("Enter the number of floor");
        int  floor=Integer.parseInt(scanner.nextLine()) ;

        Villa newVilla= new Villa(Integer.parseInt(id),name,areaUsed,rentCost,maxPeople,typeRent,standardRoom,detailConvenient,arePool,floor);

        villaList.add(newVilla);
        WriteFileCSV writeFileCSV = new WriteFileCSV();
        writeFileCSV.write(PATH_villa,newVilla.getInfo(),true);

    }
    public  static  void showVilla() {

        List<String>stringList =ReadFileCSV.readCSV(PATH_villa);
         villaList = new ArrayList<>();
        String[] temp = null;
        for (String str: stringList) {
            temp = str.split(",");
            Villa villa = new Villa(Integer.parseInt(temp[0]),temp[1],Double.parseDouble(temp[2]),Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),temp[5],temp[6],temp[7],Double.parseDouble(temp[8]),Integer.parseInt(temp[9]));
            villaList.add(villa);
        }
        for(Villa villa:villaList){
            System.out.println(villa.getInfo());

        }

        }
    }

