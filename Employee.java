package Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Simannom on 02.07.2018.
 */
public class Employee{

    private String firstName, lastName, position;
    private int Salary;

    public Employee(){
        firstName = "";
        lastName = "";
        position = "";
        Salary = 1000;
    }

    public Employee(String firstName, String lastName, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        Salary = 1000;
    }

    public Employee(String firstName, String lastName,String position, int Salary){
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.Salary = Salary;
    }


    public int getSalary() {
        return Salary;
    }

    public void changeSalary(int value) {
        this.Salary = value;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
    public String toString()
    {
        return String.format("%s %s, %s (%s)", lastName, firstName, position, Salary);
    }

    public static void main(String[] args) {
        System.out.println("Enter following data");

        List<Employee> savings = new ArrayList();

        System.out.println("Enter number of Employees you want to add");
        int n = 0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        System.out.println ("You entered number: " + n);

        Employee tmp;

        for (int i =0; i < n; ++n){
            String firstName, lastName, position;
            int Salary;
            System.out.println("Enter firstName, lastName, position and Salary of Employee you want to add");
            firstName = scan.next();
            lastName = scan.next();
            position = scan.next();
            Salary = scan.nextInt();
            tmp = new Employee(firstName, lastName, position, Salary);
            savings.add(tmp);
        }

        EmployeeComparerBySalary c = new EmployeeComparerBySalary();
        savings.sort(c);

        EmployeeComparerByLastName c2 = new EmployeeComparerByLastName();
        savings.sort(c2);
    }
}
