package entities;

public class Professor extends Employee {
    private Specialization specialization;
    private String subject;

    public Professor(Specialization specialization, String subject) {
        this.specialization = specialization;
        this.subject = subject;
    }

    public Professor() {
        this.specialization = new Specialization();
        this.subject = "";
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
