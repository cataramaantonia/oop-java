package services;

import entities.Specialization;
import entities.Student;
import repositories.StudentRepository;

import java.util.Vector;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public void addStudent(String name, float mean, int year, Specialization specialization) {
        Student student = new Student(name, mean, year, specialization);
        studentRepository.add(student);
    }

    public Student showDetails(int id) {
        return studentRepository.get(id);
    }

    public void updateStudent(int id, String name, float mean, int year, Specialization specialization) {
        Student oldStudent = studentRepository.get(id);
        Student newStudent = new Student(name, mean, year, specialization);
        studentRepository.update(oldStudent, newStudent);
    }

    public void deleteStudent(int id) {
        Student student = studentRepository.get(id);
        studentRepository.delete(student);
    }

    public Vector<Student> getAllStudents() {
        Vector<Student> students = new Vector<Student>();
        for (int i = 0; i < studentRepository.getSize(); i++) {
            students.add(studentRepository.get(i));
        }
        return students;
    }

    public Vector<Student> getStudentsWithMeanOver(float mean) {
        Vector<Student> students = new Vector<Student>();
        for (int i = 0; i < studentRepository.getSize(); i++) {
            Student student = studentRepository.get(i);
            if (student.getMean() > mean) {
                students.add(student);
            }
        }
        return students;
    }
}
