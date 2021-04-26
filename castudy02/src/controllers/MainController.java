
package controllers;

import service.HousService;
import service.RoomService;
import service.VillaService;

import java.util.Scanner;

public class MainController {
    public static Scanner sc = new Scanner(System.in);
    public  static void  showServices(){
        int choose;
        while (true){
            System.out.println("1.Show all Villa\n" +
                    "2.Show all House\n" +
                    "3.Show all Room\n" +
                    "4.Show All Name Villa Not Duplicate\n" +
                    "5.Show All Name House Not Duplicate\n" +
                    "6.Show All Name Name Not Duplicate\n" +
                    "7.Back to menu\n" +
                    "8.Exit\n");
            System.out.println("-------------------------------");
            choose= Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    VillaService.showVilla();
                    break;
                case 2:
                    RoomService.showRoom();
                    break;
                case 3:
                    HousService.showHouse();
                    break;
                case 7:
                    displayMenu();

            }

        }
    }

    public static  void addNewServices(){

        int chose;
      while (true){

            System.out.println("1.Add New Villa\n" +
                    "2.Add New House\n" +
                    "3.Add New Room\n" +
                    "4.Back to menu\n" +
                    "5.Exit\n");
            System.out.println("--------------------------------");
           chose=Integer.parseInt(sc.nextLine());
            switch (chose) {
                case 1:
                   VillaService.addNewVilla();
                   break;
                case 2:
                    HousService.addNewHouse();
                    break;
                case 3:
                   RoomService.addNewRoom();
                   break;
                case 4:
                    addNewServices();
                    break;
                case 5:
                    displayMenu();
                    break;
            }

        }


    }

    public static void displayMenu() {
        int num;
        do {
            System.out.println("---------QUAN LY FURAMA---------");
            System.out.println("chuc nang chuong trình:");
            System.out.println("1.Add New Services  ");
            System.out.println("2. Show Services ");
            System.out.println("3.Add New Customer");
            System.out.println("4.Show Information of Customer ");
            System.out.println("5.Add New Booking");
            System.out.println("6.Show Information of Employee");
            System.out.println("7.Exit");

            System.out.println("--------------------------------");

            System.out.println(" chon nhap chuc nang");
            num=Integer.parseInt(sc.nextLine());
            switch (num) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                 showServices();
                    break;
                case 3:
//                    this.AddNewCustomer();
                    break;
                case 4:
//                    this.ShowInfor();
                    break;
                case 5:
//                    this.AddNewBooking();
                    break;
                case 6:
//                   this.ShowEmployee();

            }

        }
        while (num==7);
    }

    public static void main(String[] args) {
        displayMenu();

    }

}
