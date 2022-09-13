package entities;

import java.util.Date;

public class Project {
    private String name;
    private Date presentationDate;
    private Student student;
    private Professor professor;

    public Project(String name, Date presentationDate, Student student, Professor professor) {
        this.name = name;
        this.presentationDate = presentationDate;
        this.student = student;
        this.professor = professor;
    }

    public Project() {
        this.name = "";
        this.presentationDate = new Date();
        this.student = new Student();
        this.professor = new Professor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPresentationDate() {
        return presentationDate;
    }

    public void setPresentationDate(Date presentationDate) {
        this.presentationDate = presentationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
