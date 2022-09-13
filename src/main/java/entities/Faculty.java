package entities;

public class Faculty {
    private String name;
    private Location location;
    private String university;

    public Faculty(String name, Location location, String university) {
        this.name = name;
        this.location = location;
        this.university = university;
    }

    public Faculty() {
        this.name = "";
        this.location = new Location();
        this.university = "";
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
