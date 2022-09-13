package entities;

public class Specialization {
    private String name;
    private int duration;

    public Specialization(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Specialization() {
        this.name = "";
        this.duration = 0;
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
}
