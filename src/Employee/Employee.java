package Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Simannom on 02.07.2018.
 */
public class Employee{

    private int EmployeeID;
    private String firstName, lastName, position;
    private int Salary;

    public Employee(){
        EmployeeID = 0;
        firstName = "";
        lastName = "";
        position = "";
        Salary = 1000;
    }

    public Employee(int EmployeeID,String firstName, String lastName, String position){
        this.EmployeeID = EmployeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        Salary = 1000;
    }

    public Employee(int EmployeeID, String firstName, String lastName,String position, int Salary){
        this.EmployeeID = EmployeeID;
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

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass() || obj.getClass().getName().equals("String"))
            return obj.toString().equals(this.toString());
        else return false;
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
            tmp = new Employee(i, firstName, lastName, position, Salary);
            savings.add(tmp);
        }

        EmployeeComparerBySalary c = new EmployeeComparerBySalary();
        savings.sort(c);
        for (Employee s : savings){
            System.out.println(s.toString());
        }
        System.out.println();

        EmployeeComparerByLastName c2 = new EmployeeComparerByLastName();
        savings.sort(c2);
        for (Employee s : savings){
            System.out.println(s.toString());
        }
    }
}
