package repositories;

import entities.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class StudentRepository implements GenericRepository<Student> {
    private Vector<Student> students = new Vector<Student>();


    @Override
    public void add(Student entity) {
        students.add(entity);
    }

    @Override
    public Student get(int id) {
        return students.get(id);
    }

    @Override
    public void update(Student entity, Student newEntity) {
        int index = students.indexOf(entity);
        students.set(index, newEntity);
    }

    @Override
    public void delete(Student entity) {
        students.remove(entity);
    }

    @Override
    public int getSize() {
        return students.size();
    }
}
