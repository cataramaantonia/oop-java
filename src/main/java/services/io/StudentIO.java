package services.io;

import entities.Specialization;
import entities.Student;
import repositories.StudentRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class StudentIO implements GenericIO{
    private static StudentIO instance;

    private StudentIO() {

    }

    public static StudentIO getInstance() {
        if(instance == null) {
            instance = new StudentIO();
        }
        return instance;
    }

    StudentRepository studentRepository = new StudentRepository();

    @Override
    public void read() throws IOException, ParseException {
        Scanner s = new Scanner(new File("src\\main\\java\\resources\\students.csv"));
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] values = line.split(",");
            Student student = new Student(values[0], Float.parseFloat(values[1]), parseInt(values[2]), new Specialization(values[3]));
            studentRepository.add(student);
        }
        s.close();
    }

    @Override
    public void write() throws IOException {
        String[][] students = {
                {"Popescu Ion","5.8","3","Informatica"},
                {"Gheorghe Marin","9.9","2","Matematica"},
        };
        File csv = new File("src\\main\\java\\resources\\students.csv");
        FileWriter fileWriter = new FileWriter(csv);
        for(String[] strings: students) {
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
