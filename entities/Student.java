package entities;

public class Student {
    private String name;
    private float mean;
    private int year;

    public Student(String name, float mean, int year) {
        this.name = name;
        this.mean = mean;
        this.year = year;
    }

    public Student() {
        this.name = "";
        this.mean = 0;
        this.year = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMean() {
        return mean;
    }

    public void setMean(float mean) {
        this.mean = mean;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
