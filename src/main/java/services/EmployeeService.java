package services;

import entities.Employee;
import entities.Janitor;
import repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    public void addEmployee(String name, int salary, String hireDate) {
        Employee employee = new Employee(name, salary, hireDate);
        employeeRepository.add(employee);
    }

    public Employee showDetails(int id) {
        return employeeRepository.get(id);
    }

    public void updateEmployee(int id, String name, int salary, String hireDate) {
        Employee oldEmployee = employeeRepository.get(id);
        Employee newEmployee = new Employee(name, salary, hireDate);
        employeeRepository.update(oldEmployee, newEmployee);
    }

    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.get(id);
        employeeRepository.delete(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<Employee>(employeeRepository.getSize());
        for (int i = 0; i < employeeRepository.getSize(); i++) {
            employees.add(employeeRepository.get(i));
        }
        return employees;
    }

    public ArrayList<Employee> getJanitorsWithSalaryLowerThan(int salary) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        for (int i = 0; i < employeeRepository.getSize(); i++) {
            if (employeeRepository.get(i).getClass() == Janitor.class && employeeRepository.get(i).getSalary() < salary) {
                employees.add(employeeRepository.get(i));
            }
        }
        return employees;
    }


}
