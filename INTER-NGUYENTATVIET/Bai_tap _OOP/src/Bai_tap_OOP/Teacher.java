package Bai_tap_OOP;

public class Teacher extends  Person {
    private  int salary;

    public Teacher(String name, int age, String address, int salary) {
        super(name, age, address);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Teacher() {
    }



    @Override
    public void display() {
        super.display();
    }
}
