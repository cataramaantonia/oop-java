package entities;

import java.util.Date;

public class Employee {
    protected String name;
    protected int salary;
    protected String hireDate;

    public Employee(String name, int salary, String hireDate) {
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee() {
        this.name = "";
        this.salary = 0;
        this.hireDate = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}
