package entities;

import java.util.Date;

public class Project {
    private String name;
    private Date presentationDate;

    public Project(String name, Date presentationDate) {
        this.name = name;
        this.presentationDate = presentationDate;
    }

    public Project() {
        this.name = "";
        this.presentationDate = new Date();
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
}
