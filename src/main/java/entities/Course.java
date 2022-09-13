package entities;

public class Course {
    private String name;
    private int numberHours;
    private Professor professor;

    public Course(String name, int numberHours, Professor professor) {
        this.name = name;
        this.numberHours = numberHours;
        this.professor = professor;
    }

    public Course() {
        this.name = "";
        this.numberHours = 0;
        this.professor = new Professor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberHours() {
        return numberHours;
    }

    public void setNumberHours(int numberHours) {
        this.numberHours = numberHours;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
