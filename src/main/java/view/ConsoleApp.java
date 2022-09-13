package view;

import entities.Employee;
import entities.Specialization;
import entities.Student;
import services.EmployeeService;
import services.StudentService;
import services.io.Audit;
import services.io.EmployeeIO;
import services.io.StudentIO;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleApp {
    private Scanner scanner = new Scanner(System.in);
    private StudentService studentService = new StudentService();
    private EmployeeService employeeService = new EmployeeService();

    static Audit audit;

    static {
        try {
            audit = Audit.getInstance();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public ConsoleApp() throws IOException, ParseException {
        StudentIO studentIO = StudentIO.getInstance();
        studentIO.write();
        studentIO.read();
        EmployeeIO employeeIO = EmployeeIO.getInstance();
        employeeIO.write();
        employeeIO.read();
    }

    public static void main(String[] args) throws IOException, ParseException {
        ConsoleApp consoleApp = new ConsoleApp();
        audit.write("App opened");
        while (true) {
            consoleApp.showMenu();
            int option = consoleApp.readOption();
            consoleApp.execute(option);
        }
    }

    private void execute(int option) throws IOException, ParseException {
        switch (option) {
            case 1:
                seeStudents();
                break;
            case 2:
                seeStudentDetails();
                break;
            case 3:
                addStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                editStudent();
                break;
            case 6:
                filterStudentsByMean();
                break;
            case 7:
                seeEmployees();
                break;
            case 8:
                addEmployee();
                break;
            case 9:
                editEmployee();
                break;
            case 10:
                filterJanitorsBySalary();
                break;
            case 11:
                audit.closeFileWriter();
                System.exit(0);
        }
    }

    private void filterJanitorsBySalary() throws IOException {
        System.out.println("Enter the maximum salary for the janitors");
        int salary = scanner.nextInt();
        while (salary < 0) {
            System.out.println("Invalid salary.");
            salary = scanner.nextInt();
        }
        for (Employee e : employeeService.getJanitorsWithSalaryLowerThan(salary)) {
            System.out.println(e.getName() + ":" + e.getSalary());
        }
        audit.write("Filtered janitors");
    }

    private void editEmployee() throws IOException, ParseException {
        System.out.println("Enter the number of the employee you want to edit:");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Salary: ");
        int salary = scanner.nextInt();
        System.out.println("Hire date: ");
        String hireDate1 = scanner.nextLine();
        String hireDate = scanner.nextLine();
        employeeService.updateEmployee(id - 1, name, salary, hireDate);
        audit.write("Edited employee");
    }

    private void addEmployee() throws ParseException, IOException {
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Salary: ");
        int salary = scanner.nextInt();
        System.out.println("Hire date: ");
        String hireDate1 = scanner.nextLine();
        String hireDate = scanner.nextLine();
        employeeService.addEmployee(name, salary, hireDate);
        audit.write("Added employee");
    }

    private void seeEmployees() throws IOException {
        int count = 1;
        for (Employee e : employeeService.getAllEmployees()) {
            System.out.println("#" + count);
            System.out.println("Name: " + e.getName());
            System.out.println();
            count++;
        }
        audit.write("Seen employees");
    }

    private void filterStudentsByMean() throws IOException {
        System.out.println("Enter the minimum mean for the students");
        float mean = scanner.nextFloat();
        while (mean < 1 || mean > 10) {
            System.out.println("Invalid mean.");
            mean = scanner.nextFloat();
        }
        for (Student s : studentService.getStudentsWithMeanOver(mean)) {
            System.out.println(s.getName() + ":" + s.getMean());
        }
        audit.write("Filtered students");
    }

    private void editStudent() throws IOException {
        System.out.println("Enter the number of the student you want to edit:");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Mean: ");
        float mean = scanner.nextFloat();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        System.out.println("Specialization: ");
        String specializationName1 = scanner.nextLine();
        String specializationName = scanner.nextLine();
        Specialization specialization = new Specialization(specializationName);
        studentService.updateStudent(id - 1, name, mean, year, specialization);
        audit.write("Edited student");
    }

    private void deleteStudent() throws IOException {
        System.out.println("Enter the number of the student you want to delete: ");
        int id = scanner.nextInt() - 1;
        if (id < studentService.getAllStudents().size() && id >= 0) {
            studentService.deleteStudent(id);
        } else {
            System.out.println("The student does not exist!");
            deleteStudent();
        }
        audit.write("Deleted student");
    }

    private void addStudent() throws IOException {
        System.out.print("Name: ");
        String name1 = scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Mean: ");
        float mean = scanner.nextFloat();
        System.out.println("Year: ");
        int year = scanner.nextInt();
        System.out.println("Specialization: ");
        String specializationName1 = scanner.nextLine();
        String specializationName = scanner.nextLine();
        Specialization specialization = new Specialization(specializationName);
        studentService.addStudent(name, mean, year, specialization);
        audit.write("Added student");
    }

    private void seeStudentDetails() throws IOException {
        System.out.println("Enter the number of the student you want to see: ");
        int id = scanner.nextInt();
        Student s = studentService.showDetails(id - 1);
        System.out.println("ID: " + id);
        System.out.println("Name: " + s.getName());
        System.out.println("Mean: " + s.getMean());
        System.out.println("Year: " + s.getYear());
        System.out.println("Specialization: " + s.getSpecialization().getName());
        System.out.println();
        audit.write("Seen student details");
    }

    private void seeStudents() throws IOException {
        int count = 1;
        for (Student s : studentService.getAllStudents()) {
            System.out.println("#" + count);
            System.out.println("Name: " + s.getName());
            System.out.println();
            count++;
        }
        audit.write("Seen students");
    }

    private int readOption() {
        try {
            int option = scanner.nextInt();
            if (option >= 1 && option <= 11) {
                return option;
            }
        } catch (Exception e) {
            System.out.println("Invalid option");
        }
        return readOption();
    }

    private void showMenu() {
        System.out.println();
        System.out.println("Choose option:");
        System.out.println("1. See all students.");
        System.out.println("2. Show details about a student.");
        System.out.println("3. Add a new student.");
        System.out.println("4. Delete a student.");
        System.out.println("5. Edit a student.");
        System.out.println("6. Filter students by mean.");
        System.out.println("7. See all employees.");
        System.out.println("8. Add new employee.");
        System.out.println("9. Edit an employee.");
        System.out.println("10. Filter janitors by salary.");
        System.out.println("11. Exit.");
        System.out.println();
    }
}
