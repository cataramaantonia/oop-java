package services.io;

import entities.Employee;
import entities.Specialization;
import entities.Student;
import repositories.EmployeeRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumMap;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class EmployeeIO implements GenericIO{
    private static EmployeeIO instance;

    private EmployeeIO() {

    }

    public static EmployeeIO getInstance() {
        if(instance == null) {
            instance = new EmployeeIO();
        }
        return instance;
    }

    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void read() throws IOException, ParseException {
        Scanner s = new Scanner(new File("src\\main\\java\\resources\\employees.csv"));
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] values = line.split(",");
            Employee employee = new Employee(values[0], parseInt(values[1]), values[2]);
            employeeRepository.add(employee);
        }
        s.close();
    }

    @Override
    public void write() throws IOException {
        String[][] employees = {
                {"Ciobanu Alin","2000","12/04/2005"},
                {"Ionescu Viorel","3500","25/09/2010"},
        };
        File csv = new File("src\\main\\java\\resources\\employees.csv");
        FileWriter fileWriter = new FileWriter(csv);
        for(String[] strings: employees) {
            StringBuilder line = new StringBuilder();
            for(int i=0;i<strings.length;i++) {
                line.append(strings[i]);
                if(i != strings.length - 1) {
                    line.append(",");
                }
            }
            line.append("\n");
            fileWriter.write(line.toString());
        }
        fileWriter.close();
    }
}
