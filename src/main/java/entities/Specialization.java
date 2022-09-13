package entities;

public class Specialization {
    private String name;
    private int duration;
    private Faculty faculty;

    public Specialization(String name, int duration, Faculty faculty) {
        this.name = name;
        this.duration = duration;
        this.faculty = faculty;
    }

    public Specialization() {
        this.name = "";
        this.duration = 0;
        this.faculty = new Faculty();
    }

    public Specialization(String name) {
        this.name = name;
        this.duration = 0;
        this.faculty = new Faculty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
