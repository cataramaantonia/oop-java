package entities;

public class Faculty {
    private String name;
    private Location location;

    public Faculty(String name, Location location, University university) {
        this.name = name;
        this.location = location;
        this.university = university;
    }

    public Faculty() {
        this.name = "";
        this.location = new Location();
        this.university = new University();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    private University university;
}
