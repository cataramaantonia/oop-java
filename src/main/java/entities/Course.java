package entities;

public class Course {
    private String name;
    private int numberHours;

    public Course(String name, int numberHours) {
        this.name = name;
        this.numberHours = numberHours;
    }

    public Course() {
        this.name = "";
        this.numberHours = 0;
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
}
