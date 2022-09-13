package entities;

public class University {
    private String name;

    public University(String name) {
        this.name = name;
    }

    public University() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
