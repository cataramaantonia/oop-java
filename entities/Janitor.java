package entities;

public class Janitor extends Employee {
    private Faculty faculty;

    public Janitor(Faculty faculty) {
        this.faculty = faculty;
    }

    public Janitor() {
        this.faculty = new Faculty();
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
