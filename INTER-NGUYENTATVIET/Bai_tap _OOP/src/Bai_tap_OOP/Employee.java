package Bai_tap_OOP;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;


    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();


    }

    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ",FullName=" + getFullName() +
                ", salary=" + salary +
                '}';

    }

    public static void main(String[] args) {
        /*Employee employee= new Employee(1,"A","B",1000000);
        employee.setFullName("nguyen van","Q");
        System.out.println(employee);*/
             Employee[]employees= new Employee[8];
            employees[0]= new Employee(1,"NGUYE VAN","A",10000);
            employees[1]= new Employee(2,"NGUYE VAN","B",10000);
            employees[2]= new Employee(3,"NGUYE VAN","C",10000);
            employees[3]= new Employee(4,"NGUYE VAN","D",10000);
            employees[4]= new Employee(5,"NGUYE VAN","E",10000);
            employees[5]= new Employee(6,"NGUYE VAN","F",10000);
            employees[6]= new Employee(7,"NGUYE VAN","G",10000);
            employees[7]= new Employee(8,"NGUYE VAN","H",10000);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i] );
        }

        }
    }


