package entities;

public class Professor extends Employee{
    private Specialization specialization;

    public Professor(Specialization specialization) {
        this.specialization = specialization;
    }

    public Professor() {
        this.specialization = new Specialization();
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
